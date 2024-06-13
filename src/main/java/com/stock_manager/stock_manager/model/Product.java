package com.stock_manager.stock_manager.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.stock_manager.stock_manager.model.enums.ProductCategories;
import com.stock_manager.stock_manager.utils.BarcodeUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uuid;

    private String barcode;
    private String name;
    private String description;
    private String imageUrl;
    private Integer stock;
    private Integer minimumStock;
    private ProductCategories category;

    private BigDecimal price;

    private LocalDateTime updateAt;
    private LocalDateTime createAt;
    private LocalDateTime deleteAt;

    private Boolean isActive;

    public Product(String name, String description, Integer stock, Integer minimumStock, ProductCategories category,
            BigDecimal price) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.minimumStock = minimumStock;
        this.category = category;
        this.price = price;

        this.barcode = BarcodeUtils.generateBarcode(category);
        this.updateAt = LocalDateTime.now();
        this.createAt = LocalDateTime.now();
        this.deleteAt = LocalDateTime.now();
    }

    public Product() {
    }

    
}
