package xyz.thishome.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.thishome.task.service.AsyncService;
import xyz.thishome.task.service.MailService;

@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/hello")
    public String async() {
        System.out.println("开始");
        try {
            asyncService.hello();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束");
        return "success";
    }

    @Autowired
    private MailService mailService;

    @GetMapping("/send")
    public String send() {
        mailService.sendEmail();
        return "success";
    }

}
