package com.ht.shop;

import java.io.BufferedReader;
import java.util.ArrayList;

import static com.ht.shop.ShopApplication.INVENTORIES;

public class FileReader {

  static Integer miscCount = 0;
  static Integer luxuryCount = 0;
  static Integer essentialsCount = 0;

  public static Order readCSVOrder(String filePath) {
    ArrayList<OrderItem> orderItems = new ArrayList<>();
    String row;
    try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
      // Skip column headers
      reader.readLine();
      while ((row = reader.readLine()) != null) {
        String[] data = row.split(",");
        if (data.length == 3
            && validateItem(data[0])
            && validateQuantity(data[1])
            && validateCardNumber(data[2])) {
          orderItems.add(new OrderItem(data[0], Integer.parseInt(data[1]), data[2]));
        } else {
          System.out.println("Invalid input csv data");
        }
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return new Order(orderItems, miscCount, luxuryCount, essentialsCount);
  }

  public static ArrayList<Inventory> readCSVInitInventory(String filePath) {
    ArrayList<Inventory> inventories = new ArrayList<>();
    String row;
    try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
      // Skip column headers
      reader.readLine();
      while ((row = reader.readLine()) != null) {
        String[] data = row.split(",");
        if (data.length == 4 && validateQuantity(data[2]) && validatePrice(data[3])) {
          inventories.add(
              new Inventory(
                  data[0], data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3])));
        } else {
          System.out.println("Invalid inventory dataset data");
        }
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return inventories;
  }

  private static boolean validateCardNumber(String cardNumber) {
    String card = cardNumber.replaceAll(" ", "");
    return card.matches("^\\d{16}$");
  }

  private static boolean validateItem(String itemName) {
    for (Inventory inventory : INVENTORIES) {
      if (inventory.getItem().equals(itemName)) {
        validateCategory(inventory.getCategory());
        return true;
      }
    }
    return false;
  }

  private static boolean validateQuantity(String quantity) {
    return quantity.matches("-?\\d+");
  }

  private static boolean validatePrice(String quantity) {
    return quantity.matches("[-+]?[0-9]*\\.?[0-9]+");
  }

  private static boolean validateCategory(String category) {
    if (category.equals("Misc")) miscCount++;
    if (category.equals("Essential")) essentialsCount++;
    else if (category.equals("Luxury")) luxuryCount++;
    return category.matches("Misc|Essential|Luxury");
  }
}
