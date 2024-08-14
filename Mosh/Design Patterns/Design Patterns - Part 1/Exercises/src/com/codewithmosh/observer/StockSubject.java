package com.codewithmosh.observer;

import java.util.ArrayList;
import java.util.List;

public class StockSubject {

    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void deattach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObeservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
