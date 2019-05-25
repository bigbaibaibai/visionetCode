package xyz.thishome.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async   //被此注解标记的方法，都会在一个新开的线程中执行
    public void hello() throws InterruptedException {
        System.out.println("处理数据中：" + System.currentTimeMillis());
        Thread.sleep(2000);
        System.out.println("处理数据结束：" + System.currentTimeMillis());
    }

}
