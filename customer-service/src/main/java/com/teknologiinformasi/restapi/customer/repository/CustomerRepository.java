package com.teknologiinformasi.restapi.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.teknologiinformasi.restapi.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}