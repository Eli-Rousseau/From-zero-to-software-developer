package com.codewithmosh.observer;

public class Demo {

    public static void main(String[] args) {
        Stock stockSPA = new Stock("SPA", 3);
        Stock stockEvian = new Stock("Evian", 4);

        var statusBar = new StatusBar();
        statusBar.addStock(stockEvian);
        statusBar.addStock(stockSPA);

        stockEvian.setPrice(5);
    }
}
