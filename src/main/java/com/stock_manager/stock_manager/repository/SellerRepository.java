package com.stock_manager.stock_manager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock_manager.stock_manager.model.Seller;
import java.util.UUID;


public interface SellerRepository extends JpaRepository<Seller,Long>{
    Optional<Seller> findByUuid(UUID uuid);
    Optional<Seller> findByEmail(String email);
}
