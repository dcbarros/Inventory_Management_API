package com.stock_manager.stock_manager.dto.response;

import java.math.BigDecimal;
import java.util.UUID;


public record ItemDetailsResponse(
    UUID itemUuid,
    String productName,
    String productDetail,
    Integer quantity,
    BigDecimal subtotal
) {
    
}
