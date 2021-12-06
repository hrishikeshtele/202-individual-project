package com.ht.shop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;

import static com.ht.shop.config.Config.*;
import static com.ht.shop.utils.Utils.getItemPrice;
import static com.ht.shop.utils.Utils.getItemQuantity;

public class Cart {

  public static void validateAndPlaceOrder(Order order, String cardPath) {
    double totalAmount = 0.0;
    String errMessage = "";
    String successMessage = "Item,Quantity,Price\n";
    HashSet<String> cards = new HashSet<>();
    if (order.getEssentialsCount() <= ESSENTIALS_ITEM_LIMIT
        && order.getLuxuryCount() <= LUXURY_ITEM_LIMIT
        && order.getMiscCount() <= MISC_ITEM_LIMIT) {
      // Validate if quantity is valid for all items
      for (OrderItem orderItem : order.getOrderItems()) {
        if (orderItem.getQuantity() > getItemQuantity(orderItem.getItem())) {
          errMessage = orderItem.getItem() + " " + orderItem.getQuantity() + "\n";
        } else {
          successMessage +=
              orderItem.getItem()
                  + ","
                  + orderItem.getQuantity()
                  + ","
                  + getItemPrice(orderItem.getItem(), orderItem.getQuantity())
                  + "\n";
          totalAmount += getItemPrice(orderItem.getItem(), orderItem.getQuantity());
        }
        cards.add(orderItem.getCardNumber());
      }
      if (errMessage.isEmpty()) {
        writeCardFile(cards,cardPath);
        writeOutputFile(
            SUCCESS_FILE_NAME,
            (successMessage + "Total Amount $" + totalAmount).getBytes(StandardCharsets.UTF_8));
      } else {
        writeOutputFile(
            ERROR_FILE_NAME,
            ("Please correct quantities for items " + errMessage).getBytes(StandardCharsets.UTF_8));
      }
    } else {
      writeOutputFile(
          ERROR_FILE_NAME,
          ("Please correct quantities for items. Limit for Misc is "
                  + MISC_ITEM_LIMIT
                  + ", Luxury is "
                  + LUXURY_ITEM_LIMIT
                  + " and Essential is "
                  + ESSENTIALS_ITEM_LIMIT)
              .getBytes(StandardCharsets.UTF_8));
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

  private static void writeCardFile(HashSet<String> cards, String cardPath) {
    ArrayList<String> savedCards = FileReader.readCard(cardPath);
    for (String card : savedCards) cards.add(card);
    writeOutputFile(cardPath, String.join("\n", cards).getBytes(StandardCharsets.UTF_8));
  }
}
