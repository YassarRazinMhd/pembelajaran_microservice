package com.teknologiinformasi.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teknologiinformasi.restapi.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
