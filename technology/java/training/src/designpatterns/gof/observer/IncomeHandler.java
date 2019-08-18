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
public class IncomeHandler implements Observer {

    Subject stockData = null;

    public IncomeHandler(Subject stockData) {
        this.stockData = stockData;
        stockData.addObserver(this);
    }

    @Override
    public void update(String stockSymbol, Float stockValue, Integer stockUnits) {
        System.out.println("IncomeHandler received changes... ");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
