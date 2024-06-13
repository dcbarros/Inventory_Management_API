package com.stock_manager.stock_manager.dto.request;

public record SellerUpdateDtoRequest(
    String name, 
    String email, 
    String newPassword
) {
    
}
