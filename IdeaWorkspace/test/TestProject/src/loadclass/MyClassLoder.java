package loadclass;

import java.io.*;

public class MyClassLoder extends ClassLoader {

    private String path;
    private String classLoaderName;

    public MyClassLoder(String path, String classLoaderName) {
        this.path = path;
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] b = loadClassData(name);
            return defineClass(name, b, 0, b.length);
        } catch (Exception e) {
            throw new ClassNotFoundException();
        }
    }

    private byte[] loadClassData(String name) {
        String fileName = path + "/" + name + ".class";
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             InputStream inputStream = new FileInputStream(new File(fileName))) {
            int i;
            while ((i = inputStream.read()) != -1){
                outputStream.write(i);
            }
            return outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
