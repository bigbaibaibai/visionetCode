package myproxy;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import utils.ClassUtil;
import utils.FileUtil;

import javax.lang.model.element.Modifier;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Set;

//动态生成XXXProxy这代理类，并且动态编译，再通过反射创建对象并加载到内存中
//动态生成Java源文件并且排版是一个非常繁琐的工作，为了简化操作
//我们使用 JavaPoet 这个第三方库帮我们生成TimeProxy的源码.
//希望 JavaPoet  不要成为你的负担，不理解 JavaPoet 没有关系，你只要把它当成一个Java源码生成工具使用即可。
public class MyProxy {

    private static final String CLASS_BASE_PATH = "D:\\Documents\\Note\\基础\\设计模式\\代理\\Java生成代码";
    private static final String PACKAGE_NAME = "myproxy";

    //获取代理对象
    public static <T> T newProxyInstance(Class<T> clazz, InvocationHandler invocationHandler) {
        String proxyClassName = clazz.getSimpleName() + "$MyProxy";

        try {
            //一、 生成java文件
            generateProxyJavaFile(clazz, proxyClassName);

            //二、 编译
            compileJavaFile();

            //三、 加载class文件所在目录添加到类路径
            ClassUtil.addClassPath(new File(CLASS_BASE_PATH));

            //四、 加载类并创建对象
            Class proxyClass = Class.forName(PACKAGE_NAME + "." + proxyClassName);
            return (T) proxyClass.getConstructor(InvocationHandler.class).newInstance(invocationHandler);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //生成代理类的java文件
    private static void generateProxyJavaFile(Class clazz, String proxyClassName) throws IOException {

        //动态生成代理类，继承于原类型
        TypeSpec.Builder classBuilder = TypeSpec.classBuilder(proxyClassName).addSuperinterface(clazz);

        //构建一个属性，用于保存执行对象
        FieldSpec fieldSpec = FieldSpec.builder(InvocationHandler.class, "handler", Modifier.PRIVATE).build();

        //添加到类中
        classBuilder.addField(fieldSpec);

        //构建一个构造器，初始化执行对象
        MethodSpec constructor = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(InvocationHandler.class, "handler")
                .addStatement("this.handler = handler")
                .build();

        //把构造器添加到类中
        classBuilder.addMethod(constructor);

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            MethodSpec.Builder methodSpec = MethodSpec.methodBuilder(method.getName())
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override.class)
                    .returns(method.getReturnType());
            //构造执行方法
            StringBuilder invokeString = new StringBuilder("\tthis.handler.invoke(this, " +
                    clazz.getName() + ".class.getMethod(\"" +
                    method.getName() + "\",");
            //遍历所有属性
            StringBuilder paramNames = new StringBuilder();
            for (Parameter parameter : method.getParameters()) {
                methodSpec.addParameter(parameter.getType(), parameter.getName());
                //添加到执行方法中
                invokeString.append(parameter.getType() + ".class, ");
                paramNames.append(parameter.getName() + ",");
            }
            //把最后一个逗号替换为)
            int lastCommaIndex = invokeString.lastIndexOf(",");
            invokeString.replace(lastCommaIndex, invokeString.length(), "), ");
            lastCommaIndex = paramNames.lastIndexOf(",");
            paramNames.replace(lastCommaIndex, lastCommaIndex + 1, ")");
            //把属性名追加到最后一个参数列表
            invokeString.append(paramNames);
            //添加方法体，执行InvocationHandler的invoke方法，并抓取异常
            methodSpec.addCode("try{\n");
            methodSpec.addStatement(invokeString.toString());
            methodSpec.addCode("} catch (NoSuchMethodException e) {\n");
            methodSpec.addCode("\te.printStackTrace();\n");
            methodSpec.addCode("}\n");

            //添加到类中
            classBuilder.addMethod(methodSpec.build());
        }

        //生成java文件，第一个参数是包名
//        String path = MyProxy.class.getResource("/").toString();
        JavaFile javaFile = JavaFile.builder(PACKAGE_NAME, classBuilder.build()).build();

        //把java文件写到执行路径下（默认会把包生成文件夹）
        File file = new File(CLASS_BASE_PATH);
        if (!file.exists())
            file.mkdir();
        javaFile.writeTo(file);
    }

    //把java文件编译成.class文件
    private static void compileJavaFile() throws FileNotFoundException {
        //1.获取javac编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        //2.通过javac编译器获取一个编译java文件管理器
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);

        //3.获取java文件对象   -调用一个工具类，从指定路径下，递归获取所有已java为后缀的文件
        Set<File> javaFiles = FileUtil.getFilesForSuffix(new File(CLASS_BASE_PATH), ".java");
        //- 这里就一个java文件，就直接使用了
        File[] files = javaFiles.toArray(new File[javaFiles.size()]);
        Iterable<? extends JavaFileObject> it = manager.getJavaFileObjects(files);

        //4.编译
        JavaCompiler.CompilationTask task = compiler.getTask(null, manager,
                null, null, null, it);
        task.call();
    }

}
