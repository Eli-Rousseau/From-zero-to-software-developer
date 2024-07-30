package com.codewithmosh.iterator;

import java.util.ArrayList;
import java.util.List;

public class ProductCollection implements Iteratable {
  private List<Product> products = new ArrayList<>();

  public void add(Product product) {
    products.add(product);
  }

  @Override
  public Iterator createIterator() {
    return new DynamicArrayIterator(products);
  }
}
