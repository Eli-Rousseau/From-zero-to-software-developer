package design.patterns.observer;

public class Stock extends Mutable{

    private double value;

    public Stock(double value) {
        this.value = value;
    }

    public void setValue(double value) {
        this.value = value;
        notifyObservers();
    }

    public double getValue() {
        return value;
    }
}
