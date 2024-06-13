package com.stock_manager.stock_manager.dto.request;

import java.util.UUID;

import com.stock_manager.stock_manager.model.enums.PaymentType;

public record SellUpdateDtoRequest(
    UUID selleruUuid,
    PaymentType paymentType
) {
    
}
