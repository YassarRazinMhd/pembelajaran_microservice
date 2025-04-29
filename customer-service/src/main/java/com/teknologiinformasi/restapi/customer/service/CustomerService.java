package com.teknologiinformasi.restapi.customer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.teknologiinformasi.restapi.customer.controller.CustomerController;
import com.teknologiinformasi.restapi.customer.model.Customer;
import com.teknologiinformasi.restapi.customer.repository.CustomerRepository;


import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {


   @Autowired
   private CustomerRepository customerRepository;


   public List<Customer> getAllCustomers() {
       return customerRepository.findAll();
   }


   public Optional<Customer> getCustomerById(Long id) {
       return customerRepository.findById(id);
   }


   public Customer createCustomer(Customer customer) {
       return customerRepository.save(customer);
   }


   public Customer updateCustomer(Long id, Customer customerDetails) {
    Customer customer = customerRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Customer tidak ditemukan dengan id " + id));
       customer.setName(customerDetails.getName());
       customer.setEmail(customerDetails.getEmail());
       customer.setAddress(customerDetails.getAddress());
       return customerRepository.save(customer);
   }


   public void deleteCustomer(Long id) {
    Customer customer = customerRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("customer tidak ditemukan dengan id " + id));
               customerRepository.delete(customer);
   }
}