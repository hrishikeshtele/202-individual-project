package com.ht.shop;

public class OrderItem {
  private Integer quantity;
  private String cardNumber;
  private String item;

  public OrderItem(String item, Integer quantity, String cardNumber) {
    this.item = item;
    this.quantity = quantity;
    this.cardNumber = cardNumber;
  }

  public String getItem() {
    return item;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public String getCardNumber() {
    return cardNumber;
  }
}
