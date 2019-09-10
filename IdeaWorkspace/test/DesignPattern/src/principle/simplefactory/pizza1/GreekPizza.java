package principle.simplefactory.pizza1;

public class GreekPizza extends Pizza {

    public GreekPizza() {
        System.out.println("GreekPizza . . . ");
    }

    @Override
    public void prepare() {
        System.out.println("GreekPizza prepare . . . ");
    }
}
