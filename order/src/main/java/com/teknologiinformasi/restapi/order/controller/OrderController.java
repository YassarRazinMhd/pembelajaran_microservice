package com.teknologiinformasi.restapi.order.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.teknologiinformasi.restapi.order.command.CreateOrderCommand;
import com.teknologiinformasi.restapi.order.command.UpdateOrderCommand;
import java.util.UUID;
import java.util.List;


@RestController
@RequestMapping("/api/orders")
public class OrderController {


   @Autowired
   private CommandGateway commandGateway;


   @Autowired
   private OrderSummaryRepository orderSummaryRepository;


   // Endpoint untuk membuat order (Command)
   @PostMapping
   public String createOrder(@RequestBody CreateOrderRequest request) {
       String orderId = UUID.randomUUID().toString();
       CreateOrderCommand command = new CreateOrderCommand(orderId, request.getProductId(), request.getQuantity());
       commandGateway.sendAndWait(command);
       return orderId;
   }


   // Endpoint untuk memperbarui order (Command)
   @PutMapping("/{orderId}")
   public String updateOrder(@PathVariable String orderId, @RequestBody UpdateOrderRequest request) {
       UpdateOrderCommand command = new UpdateOrderCommand(orderId, request.getProductId(), request.getQuantity(), request.getOrderStatus());
       commandGateway.sendAndWait(command);
       return orderId;
   }


   // Endpoint untuk mengambil semua order (Query)
   @GetMapping
   public List<OrderSummary> getAllOrders() {
       return orderSummaryRepository.findAll();
   }


   // Endpoint untuk mengambil order berdasarkan ID (Query)
   @GetMapping("/{orderId}")
   public OrderSummary getOrder(@PathVariable String orderId) {
       return orderSummaryRepository.findById(orderId).orElse(null);
   }
}
