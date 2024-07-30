package com.codewithmosh.iterator;

public class Demo {

    public static void main(String[] args) {
        var collection = new ProductCollection();
        collection.add(new Product(25, "Iphone"));
        collection.add(new Product(30, "Samsung"));

        var iterator = collection.createIterator();
        while (iterator.hasNext()) {
            var product = iterator.current();
            System.out.println(product);
            iterator.next();
        }
    }
}
