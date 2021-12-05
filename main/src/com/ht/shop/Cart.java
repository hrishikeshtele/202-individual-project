package com.ht.shop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.ht.shop.config.Config.*;
import static com.ht.shop.utils.Utils.getItemPrice;
import static com.ht.shop.utils.Utils.getItemQuantity;

public class Cart {

  public static void validateAndPlaceOrder(Order order) {
    Double totalAmount = 0.0;
    String errMessage = "";
    if (order.getEssentialsCount() <= ESSENTIALS_ITEM_LIMIT
        && order.getLuxuryCount() <= LUXURY_ITEM_LIMIT
        && order.getMiscCount() <= MISC_ITEM_LIMIT) {
      // Validate if quantity is valid for all items
      for (OrderItem orderItem : order.getOrderItems()) {
        if (orderItem.getQuantity() > getItemQuantity(orderItem.getItem())) {
          errMessage = orderItem.getItem() + " " + orderItem.getQuantity() + "\n";
        } else {
          totalAmount += getItemPrice(orderItem.getItem(), orderItem.getQuantity());
        }
      }
      if (errMessage.isEmpty()) {
        writeOutputFile(
            SUCCESS_FILE_NAME, ("Total Amount\n" + totalAmount).getBytes(StandardCharsets.UTF_8));
      } else {
        writeOutputFile(
            ERROR_FILE_NAME,
            ("Please correct quantities for items " + errMessage).getBytes(StandardCharsets.UTF_8));
      }
    } else {
      writeOutputFile(
          "error.txt",
          ("Please correct quantities for items " + errMessage).getBytes(StandardCharsets.UTF_8));
    }
  }

  private static void writeOutputFile(String fileName, byte[] bytes) {
    File file = new File(fileName);
    try {
      file.createNewFile();
      FileOutputStream oFile = new FileOutputStream(file, false);
      oFile.write(bytes);
      oFile.close();
    } catch (IOException e) {
      System.out.println("Error " + e.getMessage());
    }
  }
}
