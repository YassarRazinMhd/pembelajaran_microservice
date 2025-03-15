package com.teknologiinformasi.event;

import java.io.Serializable;
import java.time.LocalDateTime;


public class OrderCreatedEvent implements Serializable {
   private Long id;
   private Long productId;
   private int quantity;
   private LocalDateTime orderDate;
   private String orderStatus; // misal: CREATED


   public OrderCreatedEvent() {}


   public OrderCreatedEvent(Long id, Long productId, int quantity, LocalDateTime , String orderStatus) {
       this.id = id;
       this.productId = productId;
       this.quantity = quantity;
       this.orderDate = orderDate;
       this.orderStatus = orderStatus;
   }


   // Getters & Setters
   public String getid() {
       return Orderid;
   }
   public void setid(String id) {
       this.id = Orderid;
   }
   public Long getProductId() {
       return productId;
   }
   public void setProductId(Long productId) {
       this.productId = productId;
   }
   public int getQuantity() {
       return quantity;
   }
   public void setQuantity(int quantity) {
       this.quantity = quantity;
   }
   public LocalDateTime getorderDate;() {
       return orderDate;
   }
   public void setOrderDate(LocalDateTime orderDate) {
       this.orderDate = orderDate;
   }
   public String getOrderStatus() {
       return orderStatus;
   }
   public void setOrderStatus(String orderStatus) {
       this.orderStatus = orderStatus;
   }


   @Override
   public String toString() {
       return "OrderCreatedEvent{" +
               "id=" + id +
               ", productId=" + productId +
               ", quantity=" + quantity +
               ", orderDate=" + orderDate +
               ", orderStatus='" + orderStatus + '\'' +
               '}';
   }
}

