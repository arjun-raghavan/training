package designpatterns.gof.decorator.pizzaworld.base;

import designpatterns.gof.decorator.pizzaworld.Pizza;

public class Hawaiian extends Pizza {

    public Hawaiian(String description) {
        this.description = description + ", Hawaiian";
    }

    @Override
    public double cost() {

        return 1.50;
    }

}
