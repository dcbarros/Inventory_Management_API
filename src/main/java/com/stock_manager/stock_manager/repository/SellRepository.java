package com.stock_manager.stock_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock_manager.stock_manager.model.Sell;
import java.util.Optional;
import java.util.UUID;


public interface SellRepository extends JpaRepository<Sell, Long>{
    Optional<Sell> findByUuid(UUID uuid);
}
