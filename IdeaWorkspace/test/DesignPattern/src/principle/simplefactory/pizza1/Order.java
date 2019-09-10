package principle.simplefactory.pizza1;

public class Order {

    private Pizza pizza;

    public Order(String type) {
        switch (type) {
            case "greek":
                pizza = new GreekPizza();
            case "chess":
                pizza = new CheessPizza();
        }
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }

    public Pizza getPizza() {
        return pizza;
    }

}
