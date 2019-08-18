package designpatterns.gof.decorator.pizzaworld.base;

import designpatterns.gof.decorator.pizzaworld.Pizza;

public class Mexican extends Pizza {

	public Mexican(String description) {
		this.description = description  + ", Mexican";
	}
	
	@Override
	public double cost() {
		
		return 1.25;
	}

}
