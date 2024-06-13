package com.stock_manager.stock_manager.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock_manager.stock_manager.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    Optional<Supplier> findByUuid(UUID uuid);
}
