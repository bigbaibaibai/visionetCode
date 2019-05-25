package xyz.thishome.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;

@Controller
public class DeferredResultController {

    @RequestMapping(value = "/createOrder", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    //泛型中类型是请求实际返回类型
    public DeferredResult<Object> createOrder() {
        //设置响应时间，和如果超过响应时间发出的错误对象，这里为一个字符串
        DeferredResult deferredResult = new DeferredResult(3000L, "服务器响应超时！");
        //保存到容器（队列）中
        DeferredResultQueue.save(deferredResult);
        //返回给springMVC，主线程结束，等待setResult()方法触发，再次请求，返回结果
        return deferredResult;
    }

    @RequestMapping(value = "/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String create() {
        String s = UUID.randomUUID().toString();
        //设置请求响应结果，一旦执行这个操作，/createOrder请求就会结束，返回结果
        DeferredResultQueue.getResult().setResult(s);
        return "sucess：" + s;
    }

}
