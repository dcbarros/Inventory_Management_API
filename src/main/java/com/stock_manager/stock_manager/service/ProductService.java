package com.stock_manager.stock_manager.service;

import java.util.List;
import java.util.UUID;

import com.stock_manager.stock_manager.dto.request.ProductCreateDtoRequest;
import com.stock_manager.stock_manager.dto.request.ProductUpdateDtoRequest;
import com.stock_manager.stock_manager.dto.response.ProductFindDetailsDtoResponse;
import com.stock_manager.stock_manager.dto.response.ProductSearchDtoResponse;

public interface ProductService {
    public void createNewProduct(ProductCreateDtoRequest request);
    public void updateProductByUuid(UUID productUuid, ProductUpdateDtoRequest request);
    public ProductFindDetailsDtoResponse getProductByUuid(UUID productUuid);
    public ProductSearchDtoResponse getProductByBarcode(String barcode);
    public List<ProductSearchDtoResponse> getProductByName(String name);
    public void deleteProductByUuid(UUID productUuid);
}
