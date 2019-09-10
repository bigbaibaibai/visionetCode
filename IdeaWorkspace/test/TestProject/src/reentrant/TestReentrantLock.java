package reentrant;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {

    public static void main(String[] args) {
        new Thread(new MyReentrantLock()).start();
        new Thread(new MyReentrantLock()).start();
        new Thread(new MyReentrantLock()).start();
    }


}

class MyReentrantLock implements Runnable{

    private static volatile ReentrantLock REENTRANT_LOCK = new ReentrantLock();

    @Override
    public void run() {
        REENTRANT_LOCK.lock();
        System.out.println(Thread.currentThread().getName() + "starting . . .");
//        Condition condition = REENTRANT_LOCK.newCondition();     获取锁操作
//        condition.await();    线程进入等待池
//        condition.signal();   唤醒等待池中的一个线程
        REENTRANT_LOCK.unlock();
    }
}