package com.codewithmosh.observer;

import java.util.ArrayList;
import java.util.List;

public class StatusBar implements Observer {
    private List<Stock> stocks = new ArrayList<>();

    public void addStock(Stock stock) {
        stocks.add(stock);
        stock.attach(this);
    }

    public void show() {
        for (var stock : stocks)
            System.out.println(stock);
    }

    public void update() {
        System.out.println("The stock prices have been changed");
        show();
    }
}
