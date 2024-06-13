package com.stock_manager.stock_manager.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.stock_manager.stock_manager.model.enums.PaymentType;

public record SellDetailsDtoResponse(
    UUID uuid,
    PaymentType paymentType,
    LocalDateTime createAt,
    BigDecimal subtotal
) {
    
}
