package myproxy;

//鸟
public class Bird implements Flyable {

    //飞
    public void fly() {

        try {
            System.out.println("我是小鸟，我开始飞了");
            Thread.sleep(500);
            System.out.println("我是小鸟，我飞了500毫秒");
        } catch (InterruptedException e) {
        }

    }

}
