package com.stock_manager.stock_manager.dto.request;

public record SellerCreateDtoRequest(
    String name,
    String email,
    String password
) {
    
}
