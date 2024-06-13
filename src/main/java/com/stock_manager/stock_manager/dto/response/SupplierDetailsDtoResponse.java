package com.stock_manager.stock_manager.dto.response;

import java.util.List;
import java.util.UUID;

import com.stock_manager.stock_manager.model.Address;

public record SupplierDetailsDtoResponse(
    UUID uuid,
    String name,
    String email,
    String phone,
    List<Address> addresses
) {
    
}
