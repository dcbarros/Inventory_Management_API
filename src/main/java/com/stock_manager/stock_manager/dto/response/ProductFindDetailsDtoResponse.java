package com.stock_manager.stock_manager.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

import com.stock_manager.stock_manager.model.enums.ProductCategories;

public record ProductFindDetailsDtoResponse(
    UUID uuid,
    String name,
    String description,
    ProductCategories category,
    String imageUrl,
    Integer stock,
    Integer minimumStock,
    BigDecimal price
) {
    
}
