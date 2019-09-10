package principle.simplefactory.pizza2;

import principle.simplefactory.pizza1.CheessPizza;
import principle.simplefactory.pizza1.GreekPizza;
import principle.simplefactory.pizza1.Pizza;

public class SimplePizzaFactory {


    public Pizza createPizza(String type) {
        switch (type) {
            case "greek":
                return new GreekPizza();
            case "chess":
                return new CheessPizza();
        }
        return null;
    }

}
