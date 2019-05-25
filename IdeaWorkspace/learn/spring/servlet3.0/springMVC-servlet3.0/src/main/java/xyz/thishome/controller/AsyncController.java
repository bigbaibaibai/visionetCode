package xyz.thishome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

@Controller
public class AsyncController {

    @RequestMapping("/async")
    @ResponseBody
    public Callable<String> hello() {
        System.out.println("主线程开始" + Thread.currentThread().getName() +
                "==>" + System.currentTimeMillis());
        Callable<String> callable = new Callable<String>() {

            @Override
            public String call() throws Exception {

                System.out.println("副线程开始" + Thread.currentThread().getName() +
                        "==>" + System.currentTimeMillis());
                try {
                    sayHello();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("副线程结束" + Thread.currentThread().getName() +
                        "==>" + System.currentTimeMillis());
                return "sucess";
            }
        };
        System.out.println("主线程结束" + Thread.currentThread().getName() +
                "==>" + System.currentTimeMillis());
        return callable;
    }


    public void sayHello() throws Exception {

        Thread.sleep(3000);

    }
}
