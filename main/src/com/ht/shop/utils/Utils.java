package com.ht.shop.utils;

import com.ht.shop.Inventory;

import static com.ht.shop.ShopApplication.INVENTORIES;

public class Utils {

  public static Integer getItemQuantity(String item) {
    for (Inventory inventory : INVENTORIES) {
      if (inventory.getItem().equals(item)) return inventory.getQuantity();
    }
    return 0;
  }

  public static Double getItemPrice(String item, Integer quantity) {
    for (Inventory inventory : INVENTORIES) {
      if (inventory.getItem().equals(item)) return inventory.getPrice() * quantity;
    }
    return 0.0;
  }
}
