package com.ht.shop;

public class Inventory {

  private final String category;
  private final String item;
  private final Integer quantity;
  private final Double price;

  public Inventory(String category, String item, Integer quantity, Double price) {
    this.category = category;
    this.item = item;
    this.quantity = quantity;
    this.price = price;
  }

  public String getItem() {
    return item;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public Double getPrice() {
    return price;
  }

  public String getCategory() {return category;}
}
