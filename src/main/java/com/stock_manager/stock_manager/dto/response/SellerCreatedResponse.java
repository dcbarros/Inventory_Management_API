package com.stock_manager.stock_manager.dto.response;

import java.util.UUID;

public record SellerCreatedResponse(
    UUID uuid,
    String name,
    String email
) {
    
}
