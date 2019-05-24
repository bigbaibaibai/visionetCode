package proxy;

//鸟
public class Bird implements Flyable {

    //飞
    public void fly() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }

    }

}
