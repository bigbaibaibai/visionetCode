package xyz.thishome.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Async
    public void sendEmail() {
        //发送一个简单的邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("这是一个标题");
        message.setText("这是邮件内容");
        message.setTo("xinxiang0905@sina.com");
        message.setFrom("535122477@qq.com");
        mailSender.send(message);
    }

}
