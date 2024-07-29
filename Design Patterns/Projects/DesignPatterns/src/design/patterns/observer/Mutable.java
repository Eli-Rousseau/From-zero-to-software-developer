package design.patterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Mutable {

    private List<StockObserver> observers = new ArrayList<>();

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void removerObserver(StockObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update();
        }
    }

}
