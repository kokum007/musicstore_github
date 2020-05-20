package com.michalgoly.business;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Cart implements Serializable {

   private List<LineItem> items;

   public Cart() {
      items = new ArrayList<>();
   }

   public List<LineItem> getItems() {
      return items;
   }

   public void setItems(List<LineItem> items) {
      this.items = items;
   }

   
   public int getSize() {
      return items.size();
   }
   
   /**
    * @return The total price 
    */
   public double getTotalPrice() {
      double total = 0.0;
      for (LineItem i : items) {
         total += i.getTotalPrice();
      }

      return total;
   }
   
   
   public String getTotalPriceCurrencyFormat() {
      NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.UK);
      double totalPrice = getTotalPrice();
      return currencyFormat.format(totalPrice);
   }

   
   public void addItem(LineItem lineItem) {
      String code = lineItem.getProduct().getCode();
      int quantity = lineItem.getQuantity();

      for (LineItem i : items) {
         if (i.getProduct().getCode().equals(code)) {
            // already exists
            i.setQuantity(quantity);
            return;
         }
      }

      items.add(lineItem);
   }

   
   public void removeItem(LineItem lineItem) {
      String code = lineItem.getProduct().getCode();
      for (int i = 0; i < items.size(); i++) {
         if (items.get(i).getProduct().getCode().equals(code)) {
            items.remove(i);
            return;
         }
      }
   }
}
