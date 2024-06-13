package com.stock_manager.stock_manager.dto.request;

import java.util.UUID;

public record ItemCreateDtoRequest(
    UUID productUuid,
    Integer quantity
) {
    
}
