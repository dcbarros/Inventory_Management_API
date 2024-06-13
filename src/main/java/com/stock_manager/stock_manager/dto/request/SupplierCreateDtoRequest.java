package com.stock_manager.stock_manager.dto.request;

import java.util.List;

import com.stock_manager.stock_manager.model.Address;

public record SupplierCreateDtoRequest(
    String name,
    String email,
    String phone,
    List<Address> addresses
) {
    
}
