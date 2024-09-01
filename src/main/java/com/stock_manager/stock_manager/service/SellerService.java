package com.stock_manager.stock_manager.service;

import java.util.UUID;

import com.stock_manager.stock_manager.dto.request.SellerCreateDtoRequest;
import com.stock_manager.stock_manager.dto.request.SellerUpdateDtoRequest;
import com.stock_manager.stock_manager.dto.response.SellerCreatedResponse;
import com.stock_manager.stock_manager.dto.response.SellerDetailsDtoResponse;

public interface SellerService {
    public SellerCreatedResponse createNewSeller(SellerCreateDtoRequest request);
    public void updateSellerByUuid(UUID sellerUuid, SellerUpdateDtoRequest request);
    public SellerDetailsDtoResponse getSellerByUuid(UUID sellerUuid);
    public void deactivateSellerByUuid(UUID sellerUuid);
}
