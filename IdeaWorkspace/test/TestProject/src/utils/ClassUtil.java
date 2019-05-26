package utils;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Set;
import java.util.Stack;

public class ClassUtil {

    /**
     * 加载class文件
     *
     * @param classFolder
     * @throws Exception
     */
    public static <T> void loadClass(File classFolder) throws Exception {

        //获取URLClassLoader的addURL方法
        Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
        boolean accessible = method.isAccessible();
        try {
            //如果方法没有权限访问，则设置可访问权限
            if (accessible == false) {
                method.setAccessible(true);
            }
            // 设置类加载器
            URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
            // 将当前类路径加入到类加载器中
            method.invoke(classLoader, classFolder.toURI().toURL());
        } finally {
            //把方法的权限设置回去
            method.setAccessible(accessible);
        }

        Set<File> files = FileUtil.getFilesForSuffix(classFolder, ".class");
        for (File file : files) {
            // 把文件名称转化为，和java.lang.String类似的全类名
            String className = file.getAbsolutePath();
            className = className.substring(classFolder.getAbsolutePath().length() + 1, className.length() - 6);
            className = className.replace(File.separatorChar, '.');
            // 加载Class类
            Class.forName(className);
        }

    }

    /**
     * 加载指定文件夹下的.class文件到jvm中
     *
     * @param
     * @throws Exception
     */
    private void loadClassOld(File clazzPath) throws Exception {
        // 设置class文件所在根路径
        // 例如/usr/java/classes下有一个test.App类，则/usr/java/classes即这个类的根路径，而.class文件的实际位置是/usr/java/classes/test/App.class

        // 记录加载.class文件的数量
        int clazzCount = 0;

        //如果文件路径存在，并且是一个目录
        if (clazzPath.exists() && clazzPath.isDirectory()) {
            int clazzPathLen = clazzPath.getAbsolutePath().length() + 1;
            //创建一个栈，用于当前目录下遍历所有的目录
            Stack<File> stack = new Stack<>();
            //先把最外层的目录添加到栈中
            stack.push(clazzPath);

            // 遍历类路径
            while (stack.isEmpty() == false) {
                File path = stack.pop();
                //过滤文件，留下目录，和.class文件
                File[] classFiles = path.listFiles((pathname) -> pathname.isDirectory() || pathname.getName().endsWith(".class"));
                //遍历当前文件夹下的所有文件
                for (File subFile : classFiles) {
                    if (subFile.isDirectory()) {
                        //如果是目录，压入栈中，稍后遍历
                        stack.push(subFile);
                        //如果是.class文件，加载类
                    } else {
                        //第一次加载（表示是最外层目录，即加载.class文件的根目录）
                        if (clazzCount++ == 0) {
                            //获取URLClassLoader的addURL方法
                            Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
                            boolean accessible = method.isAccessible();
                            try {
                                //如果方法没有权限访问，则设置可访问权限
                                if (accessible == false) {
                                    method.setAccessible(true);
                                }
                                // 设置类加载器
                                URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
                                // 将当前类路径加入到类加载器中
                                method.invoke(classLoader, clazzPath.toURI().toURL());
                            } finally {
                                //把方法的权限设置回去
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
