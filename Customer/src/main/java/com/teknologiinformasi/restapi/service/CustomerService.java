package com.teknologiinformasi.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teknologiinformasi.restapi.model.Customer;
import com.teknologiinformasi.restapi.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

   @Autowired
   private CustomerRepository customerRepository; // Nama variabel diperbaiki

   // Mendapatkan semua customer
   public List<Customer> getAllCustomer() {
       return customerRepository.findAll();
   }

   // Mendapatkan customer berdasarkan ID
   public Optional<Customer> getCustomerById(Long id) {
       return customerRepository.findById(id);
   }

   // Membuat customer baru
   public Customer createCustomer(Customer customer) {
       return customerRepository.save(customer);
   }

   // Update customer berdasarkan ID
   public Customer updateCustomer(Long id, Customer customerDetails) {
       Customer customer = customerRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Customer tidak ditemukan dengan id " + id));

       // Mengupdate atribut yang sesuai dengan Customer
       customer.setNama(customerDetails.getNama());
       customer.setEmail(customerDetails.getEmail());
       customer.setAddress(customerDetails.getAddress());

       return customerRepository.save(customer);
   }

   // Menghapus customer berdasarkan ID
   public void deleteCustomer(Long id) {
       Customer customer = customerRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Customer tidak ditemukan dengan id " + id));
       customerRepository.delete(customer);
   }
}
