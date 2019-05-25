package xyz.thishome.phone_search.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import xyz.thishome.common.pojo.PhoneMsg;

@Aspect
public class ControllerExceptionAop {

    //定义切面表达式
    // 内部引用，写方法名即可，pointCut()
    // 外部引用，写方法名全限定名，xyz.thishome.aop.LogAspects.pointCut()
    @Pointcut("execution(* xyz.thishome.phone_search.controller.*.*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")    //环绕通知处理异常
    public Object exceptionHandle(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Object result = null;
            System.out.println("切面执行");
            result = joinPoint.proceed(joinPoint.getArgs());
            return result;
        } catch (Exception e) {
            //注意，int类型返回值不能为null，所以如果发生异常返回0
            e.printStackTrace();
            return PhoneMsg.bulid("程序异常");
        }
    }

}
