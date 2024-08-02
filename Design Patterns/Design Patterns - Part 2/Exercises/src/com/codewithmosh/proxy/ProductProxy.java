package com.codewithmosh.proxy;

import java.util.ArrayList;
import java.util.List;

public class ProductProxy implements Product {
    private ProductReal realProduct;
    private List<DbContext> databases = new ArrayList<>();

    public ProductProxy(ProductReal realProduct)  {
        this.realProduct = realProduct;
    }

    @Override
    public int getId() {
        return realProduct.getId();
    }

    @Override
    public String getName() {
        return realProduct.getName();
    }

    @Override
    public void setName(String name) {
        realProduct.setName(name);
        for (DbContext database: databases) {
            database.markAsChanged(this);
        }
    }

    public void addDatabase(DbContext database) {
        databases.add(database);
    }
}
