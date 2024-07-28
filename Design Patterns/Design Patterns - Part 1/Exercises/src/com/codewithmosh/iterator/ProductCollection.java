package com.codewithmosh.iterator;

import java.util.ArrayList;
import java.util.List;

public class ProductCollection {
  private List<Product> products = new ArrayList<>();

  public void add(Product product) {
    products.add(product);
  }

  public Iterator<Product> iteratorCreator() {
    return new ListArrayIterator(this);
  }

  public class ListArrayIterator implements Iterator {

    private ProductCollection productsCollection;
    private int iterationIndex = 0;

    public ListArrayIterator(ProductCollection productsCollection) {
      this.productsCollection = productsCollection;
    }

    @Override
    public boolean hasNext() {
      return (iterationIndex < productsCollection.products.size());
    }

    @Override
    public Object current() {
      return productsCollection.products.get(iterationIndex);
    }

    @Override
    public void next() {
      iterationIndex++;
    }
  }

}
