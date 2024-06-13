package com.stock_manager.stock_manager.dto.request;

import com.stock_manager.stock_manager.model.Seller;
import com.stock_manager.stock_manager.model.enums.PaymentType;

public record SellCreateDtoRequest(
    Seller seller, 
    PaymentType paymentType
) {
    
}
