package test;

public class TestThread {

    public static void main(String[] args) {
        System.out.println();
        Print print = new Print();
        new Thread(print).start();
        new Thread(print).start();
        new Thread(print).start();

    }

}

class Print implements Runnable {
    static int num;

    @Override
    public void run() {
        String s = "";
        synchronized (s) {
            for (int i = 0; i < 10; i++) {
                num++;
                try {
                    Thread.sleep(30);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.print(num + " - ");
            }
            System.out.println();
        }
    }
}
