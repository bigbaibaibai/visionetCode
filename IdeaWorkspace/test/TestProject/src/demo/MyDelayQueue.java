package demo;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

public class MyDelayQueue {
    public static void main(String[] args) {
        DelayQueue queue = new DelayQueue();
        queue.offer(new MyMessage(1,"销毁订单！",1000));
        System.out.println(System.currentTimeMillis());
        try {
            Delayed take = queue.take();
            if (take instanceof MyMessage){
                System.out.println(((MyMessage) take).getBody());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis());
    }


}
