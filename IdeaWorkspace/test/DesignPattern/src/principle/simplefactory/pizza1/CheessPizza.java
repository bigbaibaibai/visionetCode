package principle.simplefactory.pizza1;

public class CheessPizza extends Pizza {

    public CheessPizza(){
        System.out.println("CheessPizza . . . ");
    }


    @Override
    public void prepare() {
        System.out.println("CheessPizza prepare . . . ");
    }
}
