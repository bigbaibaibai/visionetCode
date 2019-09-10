package thread;

import java.util.concurrent.Callable;

/**
 * @Time: 2019/7/20 10:12
 * @Author: bxx
 * @Description: 测试MyCallable接口
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() {
        System.out.println("call begin");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        System.out.println("call end");
        return "hello";
    }
}
