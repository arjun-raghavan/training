/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.gof.decorator.pizzaworld;

/**
 *
 * @author Arjun
 */
public abstract class Pizza {

    protected String description = null;

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
