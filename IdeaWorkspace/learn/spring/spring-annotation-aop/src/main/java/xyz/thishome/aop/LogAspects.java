package xyz.thishome.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 日志切面类
 */
@Aspect  //表示当前类是一个切面类
public class LogAspects {

    //定义切面表达式
    // 内部引用，写方法名即可，pointCut()
    // 外部引用，写方法名全限定名，xyz.thishome.aop.LogAspects.pointCut()
    @Pointcut("execution(public int xyz.thishome.bean.MathCalculator.*(..))")
    public void pointCut() {
    }

    //前置通知，在目标方法执行之前执行，调用切面表达式
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {  //JoinPoint对象，获取方法的详细信息
        //获取方法签名，通过方法签名对象获取方法名
        String name = joinPoint.getSignature().getName();
        //获取参数列表
        Object[] params = joinPoint.getArgs();
        //打印日志
        System.out.println(name + "方法开始，参数为：" + Arrays.asList(params));
    }

    //后置通知，在目标方法执行之后执行
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "方法结束");
    }

    //返回通知，在目标方法*正常*返回之后执行
    @AfterReturning(value = "pointCut()", returning = "result")  //指定需要接受返回值的参数
    public void logReturn(JoinPoint joinPoint, Object result/*接受返回值的参数*/) {
        System.out.println(joinPoint.getSignature().getName() + "方法正常返回，运行结果为：" + result);
    }

    //异常通知，在目标方法抛出异常之后执行
    @AfterThrowing(value = "pointCut()", throwing = "e") //指定需要接受异常对象的参数名
    public void logException(JoinPoint joinPoint, Exception e/*接受异常对象的参数*/) {
        System.out.println(joinPoint.getSignature().getName() + "方法异常，异常信息为：" + e);
    }

    @Around("pointCut()")    //环绕通知处理异常
    public Object exceptionHandle(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Object result = null;
            result = joinPoint.proceed(joinPoint.getArgs());
            return result;
        } catch (Exception e) {
            //注意，int类型返回值不能为null，所以如果发生异常返回0
            return 0;
        }
    }
}
