package thread;

import java.util.concurrent.FutureTask;

public class TestCallable {

    public static void main(String[] args) throws Exception {
        FutureTask futureTask = new FutureTask(new MyCallable());
        new Thread(futureTask).start();
        if (!futureTask.isDone()) {
            System.out.println("还没执行完");
        }
        System.out.println("return is:" + futureTask.get());
    }

}
