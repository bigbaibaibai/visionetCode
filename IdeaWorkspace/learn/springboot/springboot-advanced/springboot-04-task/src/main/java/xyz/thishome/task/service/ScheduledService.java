package xyz.thishome.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    //@Scheduled(cron = "0 * * * * 3")  //时间表达式
    public void hello() {
        System.out.println("hello");
    }

}
