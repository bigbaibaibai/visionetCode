package singleton;

public class FileSinleton {
    private static FileSinleton ourInstance = new FileSinleton();

    public static FileSinleton getInstance() {
        return ourInstance;
    }

    private FileSinleton() {
    }
}
