package com.stock_manager.stock_manager.service;

import java.util.UUID;

import com.stock_manager.stock_manager.dto.request.SupplierCreateDtoRequest;
import com.stock_manager.stock_manager.dto.request.SupplierUpdateDtoRequest;
import com.stock_manager.stock_manager.dto.response.SupplierDetailsDtoResponse;

public interface SupplierService {
    public void createNewSupplier(SupplierCreateDtoRequest request);
    public void updateSupplierByUuid(UUID supplierUuid,SupplierUpdateDtoRequest request);
    public SupplierDetailsDtoResponse getSupplierByUuid(UUID supplierUuid);
    public void deleteSupplierByUuid(UUID supplierUuid);
}
