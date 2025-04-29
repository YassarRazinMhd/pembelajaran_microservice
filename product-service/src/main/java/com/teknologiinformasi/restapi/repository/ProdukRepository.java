package com.teknologiinformasi.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teknologiinformasi.restapi.model.Produk;


@Repository
public interface ProdukRepository extends JpaRepository<Produk, Long> {
}
