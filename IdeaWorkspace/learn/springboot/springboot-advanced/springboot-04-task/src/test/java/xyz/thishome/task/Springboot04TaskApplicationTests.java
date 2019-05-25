package xyz.thishome.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot04TaskApplicationTests {


    @Autowired
    private JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
        //发送一个简单的邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("这是一个标题");
        message.setText("这是邮件内容");
        //设置发送目标
        message.setTo("xinxiang0905@sina.com");
        //设置发送者
        message.setFrom("535122477@qq.com");
        mailSender.send(message);
    }

    @Test
    public void testSend() throws Exception{
        //创建一个复杂邮件对象
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //创建复杂邮件帮助器，传入复杂邮件对象，第二个参数为是否发送附件
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);

        //添加第一个附件，第一个参数为文件名，第二个参数为文件流（可以是一个inputstream）
        message.addAttachment("1.png",new File("C:\\Users\\Administrator\\Desktop\\Idea配置版快捷键.png"));
        //添加第二个附件
        message.addAttachment("2.png",new File("C:\\Users\\Administrator\\Desktop\\索引优化关键.png"));

        message.setSubject("这是一个标题");
        //第二个参数为，是否是html片段
        message.setText("<b>这是邮件内容</b>",true);
        //设置发送目标
        message.setTo("xinxiang0905@sina.com");
        //设置发送者
        message.setFrom("535122477@qq.com");
        //获取邮件对象并发送
        mailSender.send(message.getMimeMessage());
    }

}

