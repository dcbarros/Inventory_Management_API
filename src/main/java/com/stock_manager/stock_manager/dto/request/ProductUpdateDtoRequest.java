package com.stock_manager.stock_manager.dto.request;

import java.math.BigDecimal;

import com.stock_manager.stock_manager.model.enums.ProductCategories;

public record ProductUpdateDtoRequest(
    String name,
    String description, 
    Integer stock, 
    Integer minimumStock, 
    ProductCategories category,
    BigDecimal price
) {
    
}
