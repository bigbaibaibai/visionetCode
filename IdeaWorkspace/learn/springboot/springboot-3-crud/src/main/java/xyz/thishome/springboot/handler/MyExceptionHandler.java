package xyz.thishome.springboot.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.thishome.springboot.exception.UserNotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//异常控制器

@ControllerAdvice
public class MyExceptionHandler {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String , Object> handlerException(Exception e, HttpServletRequest request){
        Map<String , Object> map=new HashMap<String ,Object>();
        map.put("message","用户不存在");
        return map;
    }

}