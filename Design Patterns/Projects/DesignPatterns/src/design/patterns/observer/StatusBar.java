package design.patterns.observer;

public class StatusBar implements StockObserver{

    private Stock stock;

    public StatusBar(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void update() {
        System.out.println("Status bar: " + stock.getValue());
    }
}
