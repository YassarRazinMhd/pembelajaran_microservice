package com.teknologiinformasi.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.teknologiinformasi.restapi.model.Customer;
import com.teknologiinformasi.restapi.service.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {


   @Autowired
   private CustomerService CustomerService;


   // Endpoint untuk mengambil semua Customer
   @GetMapping
   public List<Customer> getAllCustomer() {
       return CustomerService.getAllCustomer();
   }


   // Endpoint untuk mengambil Customer berdasarkan id
   @GetMapping("/{id}")
   public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
       return CustomerService.getCustomerById(id)
               .map(Customer -> ResponseEntity.ok().body(Customer))
               .orElse(ResponseEntity.notFound().build());
   }


   // Endpoint untuk membuat Customer baru
   @PostMapping
   public Customer createCustomer(@RequestBody Customer Customer) {
       return CustomerService.createCustomer(Customer);
   }


   // Endpoint untuk mengupdate Customer yang sudah ada
   @PutMapping("/{id}")
   public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer CustomerDetails) {
       try {
           Customer updatedCustomer = CustomerService.updateCustomer(id, CustomerDetails);
           return ResponseEntity.ok(updatedCustomer);
       } catch (RuntimeException e) {
           return ResponseEntity.notFound().build();
       }
   }


   // Endpoint untuk menghapus Customer
  @DeleteMapping("/{id}")
public ResponseEntity<Map<String, String>> deleteCustomer(@PathVariable Long id) {
   try {
       CustomerService.deleteCustomer(id);
       Map<String, String> response = new HashMap<>();
       response.put("message", "Customer berhasil dihapus");
       return ResponseEntity.ok(response);
   } catch (RuntimeException e) {
       Map<String, String> response = new HashMap<>();
       response.put("message", "Customer tidak ditemukan dengan id " + id);
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
   }
}
}
