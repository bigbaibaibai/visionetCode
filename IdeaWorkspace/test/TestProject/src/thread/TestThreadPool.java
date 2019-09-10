package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Time: 2019/7/20 18:04
 * @Author: bxx
 * @Description: 测试有返回值的线程池
 */
public class TestThreadPool {

    public static void main(String[] args) {
        //创建一个Future线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        //提交一个线程
        Future<String> future = newCachedThreadPool.submit(new MyCallable());
        if (!future.isDone()) {
            System.out.println("还没有结束");
        }
        try {
            System.out.println(future.get());
        } catch (Exception e) {
        } finally {
            newCachedThreadPool.shutdown();
        }

    }

}
