package com.stock_manager.stock_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock_manager.stock_manager.model.Product;
import java.util.Optional;
import java.util.UUID;


public interface ProductRepository extends JpaRepository<Product, Long>{
    Optional<Product> findByUuid(UUID uuid);
}
