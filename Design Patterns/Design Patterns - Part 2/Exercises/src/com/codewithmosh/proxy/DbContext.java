package com.codewithmosh.proxy;

import java.util.HashMap;
import java.util.Map;

public class DbContext {
  private Map<Integer, ProductProxy> updatedObjects = new HashMap<>();

  public ProductProxy getProduct(int id) {
    // Automatically generate SQL statements
    // to read the product with the given ID.
    System.out.printf("SELECT * FROM products WHERE product_id = %d \n", id);

    // Simulate reading a product object from a database.
    var product = new ProductProxy(new ProductReal(id));
    product.setName("Product "+ id);
    product.addDatabase(this);

    return product;
  }

  public void saveChanges() {
    // Automatically generate SQL statements
    // to update the database.
    for (var updatedObject : updatedObjects.values())
      System.out.printf("UPDATE products SET name = '%s' WHERE product_id = %d \n", updatedObject.getName(), updatedObject.getId());

    updatedObjects.clear();
  }

  public void markAsChanged(ProductProxy product) {
    updatedObjects.put(product.getId(), product);
  }
}
