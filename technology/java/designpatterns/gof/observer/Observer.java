/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.gof.observer;

/**
 *
 * @author Arjun
 */
public interface Observer {

    public void update(String stockSymbol, Float stockValue, Integer stockUnits);
}
