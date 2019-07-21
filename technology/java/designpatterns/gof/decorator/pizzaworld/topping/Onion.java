package designpatterns.gof.decorator.pizzaworld.topping;

import designpatterns.gof.decorator.pizzaworld.Pizza;
import designpatterns.gof.decorator.pizzaworld.ToppingDecorator;

public class Onion extends ToppingDecorator {

	Pizza pizza;
	
	public Onion(Pizza pizza) {
		
		this.pizza = pizza;
	}
	
	@Override
	public String getDescription() {
		
		return pizza.getDescription() + ", Onion";
	}

	@Override
	public double cost() {
		
		return (0.15 + pizza.cost());
	}

	
}
