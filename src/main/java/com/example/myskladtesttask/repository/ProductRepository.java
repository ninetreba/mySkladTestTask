package com.example.myskladtesttask.repository;

import com.example.myskladtesttask.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
