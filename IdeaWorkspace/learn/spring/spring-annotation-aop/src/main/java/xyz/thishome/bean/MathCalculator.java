package xyz.thishome.bean;

        import org.springframework.beans.factory.support.RootBeanDefinition;

public class MathCalculator {

    public int dev(int i, int j) {
        System.out.println("MathCalculator dev被调用");

        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        return i / j;
    }

}
