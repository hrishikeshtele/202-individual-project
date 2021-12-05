package com.ht.shop;

import java.util.ArrayList;

public class Order {

  private final ArrayList<OrderItem> orderItems;
  private final Integer miscCount;
  private final Integer luxuryCount;
  private final Integer essentialCount;

  public Order(
      ArrayList<OrderItem> orderItems,
      Integer miscCount,
      Integer luxuryCount,
      Integer essentialsCount) {
    this.orderItems = orderItems;
    this.miscCount = miscCount;
    this.luxuryCount = luxuryCount;
    this.essentialCount = essentialsCount;
  }

  public ArrayList<OrderItem> getOrderItems() {
    return orderItems;
  }

  public Integer getMiscCount() {
    return miscCount;
  }

  public Integer getLuxuryCount() {
    return luxuryCount;
  }

  public Integer getEssentialsCount() {
    return essentialCount;
  }
}
