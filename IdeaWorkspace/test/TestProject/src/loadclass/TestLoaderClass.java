package loadclass;

public class TestLoaderClass {

    public static void main(String[] args) {
        try {
            Class<?> loadClass = new MyClassLoder("D:\\Documents", "MyClassLoader").loadClass("Wali");
            Object o = loadClass.newInstance();
            System.out.println(o);

        } catch (Exception e) {
        }
    }

}
