package com.stock_manager.stock_manager.dto.response;

import java.util.List;
import java.util.UUID;

import com.stock_manager.stock_manager.model.Sell;

public record SellerDetailsDtoResponse(
    UUID uuid,
    String name,
    String email,
    List<Sell> sells
) {
    
}
