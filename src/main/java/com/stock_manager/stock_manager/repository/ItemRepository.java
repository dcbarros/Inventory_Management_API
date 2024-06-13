package com.stock_manager.stock_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock_manager.stock_manager.model.Item;
import java.util.Optional;
import java.util.UUID;


public interface ItemRepository extends JpaRepository<Item,Long>{
    Optional<Item> findByUuid(UUID uuid);
}
