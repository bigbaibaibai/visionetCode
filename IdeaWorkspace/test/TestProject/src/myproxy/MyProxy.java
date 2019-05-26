package myproxy;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Stack;

//动态生成XXXProxy这代理类，并且动态编译，再通过反射创建对象并加载到内存中
//动态生成Java源文件并且排版是一个非常繁琐的工作，为了简化操作
//我们使用 JavaPoet 这个第三方库帮我们生成TimeProxy的源码.
//希望 JavaPoet  不要成为你的负担，不理解 JavaPoet 没有关系，你只要把它当成一个Java源码生成工具使用即可。
public class MyProxy {

    //获取代理对象
    public static <T> T newProxyInstance(Class<T> clazz, InvocationHandler invocationHandler) {

        String proxyClassName = clazz.getSimpleName() + "$MyProxy";
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
            for (Parameter parameter : method.getParameters()) {
                methodSpec.addParameter(parameter.getType(), parameter.getName(), Modifier.PUBLIC);
                //添加到执行方法中
                invokeString.append(parameter.getName() + ",");
            }
            int i = invokeString.lastIndexOf(",");
            //删除最后一个逗号
            invokeString.deleteCharAt(i);
            invokeString.append("))");
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
        JavaFile javaFile = JavaFile.builder("myproxy", classBuilder.build()).build();

        try {
            String baseUrl = "C:\\Users\\bai\\Desktop\\myproxy";

            //把java文件写到执行路径下（默认会把包生成文件夹）
            javaFile.writeTo(new File(baseUrl));
            //把java文件编译成class
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> it = manager.getJavaFileObjects(baseUrl + "\\myproxy\\" + proxyClassName + ".java");
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, it);
            task.call();

            //加载class文件到jvm中
            loadClass(baseUrl);

            //创建对象
            Class proxyClass = MyProxy.class.getClassLoader().loadClass("myproxy." + proxyClassName);

            return (T) proxyClass.getConstructor(InvocationHandler.class).newInstance(invocationHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void loadClass(String pathStr) throws Exception {
        // 设置class文件所在根路径
        // 例如/usr/java/classes下有一个test.App类，则/usr/java/classes即这个类的根路径，而.class文件的实际位置是/usr/java/classes/test/App.class
        File clazzPath = new File(pathStr);

        // 记录加载.class文件的数量
        int clazzCount = 0;

        //如果文件路径存在，并且是一个目录
        if (clazzPath.exists() && clazzPath.isDirectory()) {
            int clazzPathLen = clazzPath.getAbsolutePath().length() + 1;
            Stack<File> stack = new Stack<>();
            stack.push(clazzPath);

            // 遍历类路径
            while (stack.isEmpty() == false) {
                File path = stack.pop();
                //把路径文件夹下
                File[] classFiles = path.listFiles((pathname) -> pathname.isDirectory() || pathname.getName().endsWith(".class"));
                for (File subFile : classFiles) {
                    if (subFile.isDirectory()) {
                        stack.push(subFile);
                    } else {
                        if (clazzCount++ == 0) {
                            Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
                            boolean accessible = method.isAccessible();
                            try {
                                if (accessible == false) {
                                    method.setAccessible(true);
                                }
                                // 设置类加载器
                                URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
                                // 将当前类路径加入到类加载器中
                                method.invoke(classLoader, clazzPath.toURI().toURL());
                            } finally {
                                method.setAccessible(accessible);
                            }
                        }
                        // 文件名称
                        String className = subFile.getAbsolutePath();
                        className = className.substring(clazzPathLen, className.length() - 6);
                        className = className.replace(File.separatorChar, '.');
                        // 加载Class类
                        Class.forName(className);
                    }
                }
            }
        }
    }

}
