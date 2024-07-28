package com.codewithmosh.iterator;

public class Main {
    public static void main(String[] args) {
        var collection = new ProductCollection();
        collection.add(new Product(1, "Eli"));
        collection.add(new Product(2, "Mariam"));

        var iterator = collection.iteratorCreator();
        while (iterator.hasNext()) {
            var currentProduct = iterator.current();
            System.out.println(currentProduct);
            iterator.next();
        }
    }
}
