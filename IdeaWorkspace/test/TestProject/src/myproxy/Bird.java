package myproxy;

//鸟
public class Bird implements Flyable {

    //飞
    @Override
    public void fly(long time) {

        try {
            System.out.println("我是小鸟，我开始飞了");
            Thread.sleep(time);
            System.out.println("我是小鸟，我飞了" + time + "毫秒");
        } catch (InterruptedException e) {
        }

    }

}
