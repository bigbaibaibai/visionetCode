package singleton;

public class Singleton {
    private Singleton() {
        System.out.println("Singleton构造函数");
    }

    private static Singleton singleton = null;

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                    System.out.println("singleton创建成功");
                }
            }
        }
        return singleton;
    }

    public static void show() {
        System.out.println("我是单例");
    }

}
