package com.ht.shop;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/** The type Shop application. */
public class ShopApplication {

  /** The Inventories. This is a singleton object which follows singleton design pattern */
  public static ArrayList<Inventory> INVENTORIES;

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    // Validate and read input CSV file
    Path inventoryPath = Paths.get(args[0]);
    Path orderPath = Paths.get(args[1]);
    Path cardPath = Paths.get(args[2]);
    INVENTORIES = FileReader.readCSVInitInventory(inventoryPath.toString());
    Order order = FileReader.readCSVOrder(orderPath.toString());
    Cart.validateAndPlaceOrder(order,cardPath.toString());
  }
}
