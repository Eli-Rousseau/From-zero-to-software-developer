package com.codewithmosh.proxy;

public class ProductReal implements Product {
  private int id;
  private String name;

  public ProductReal(int id) {
    this.id = id;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }
}
