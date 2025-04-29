package com.teknologiinformasi.restapi.order.controller;


import com.teknologiinformasi.restapi.order.command.CreateOrderCommand;
import com.teknologiinformasi.restapi.order.command.UpdateOrderCommand;
import com.teknologiinformasi.restapi.order.model.CreateOrderRequest;
import com.teknologiinformasi.restapi.order.model.UpdateOrderRequest;
import com.teknologiinformasi.restapi.order.repository.OrderSummaryRepository;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private OrderSummaryRepository orderSummaryRepository;

     public OrderController(CommandGateway commandGateway, OrderSummaryRepository orderRepository) {
        this.commandGateway = commandGateway;
        this.orderSummaryRepository = orderRepository;
    }
    // Endpoint untuk membuat order (Command)
    @PostMapping
    public String createOrder(@RequestBody CreateOrderRequest request) {
        String orderId = UUID.randomUUID().toString();
        CreateOrderCommand command = new CreateOrderCommand(orderId, request.getProductId(), request.getQuantity());
        commandGateway.sendAndWait(command);
        // Ambil data order yang baru dibuat dari database
    return orderId;
    }

    // Endpoint untuk memperbarui order (Command)
    @PutMapping("/{orderId}")
    public String updateOrder(@PathVariable String orderId, @RequestBody UpdateOrderRequest request) {
        UpdateOrderCommand command = new UpdateOrderCommand(orderId, request.getProductId(), request.getQuantity(), request.getOrderStatus());
        commandGateway.sendAndWait(command);
        return orderId;
    }

  
}