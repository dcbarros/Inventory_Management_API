package com.stock_manager.stock_manager.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.stock_manager.stock_manager.dto.request.ProductCreateDtoRequest;
import com.stock_manager.stock_manager.dto.request.ProductUpdateDtoRequest;
import com.stock_manager.stock_manager.dto.response.ProductFindDetailsDtoResponse;
import com.stock_manager.stock_manager.dto.response.ProductSearchDtoResponse;
import com.stock_manager.stock_manager.exception.ExcededAttmptsException;
import com.stock_manager.stock_manager.model.Product;
import com.stock_manager.stock_manager.model.enums.ProductCategories;
import com.stock_manager.stock_manager.repository.ProductRepository;
import com.stock_manager.stock_manager.service.ProductService;
import com.stock_manager.stock_manager.utils.BarcodeUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public void createNewProduct(ProductCreateDtoRequest request) {
        if(request.category() == null) throw new IllegalArgumentException("A categoria do produto não pode ser nula.");
        if(request.stock() < 0) throw new IllegalArgumentException("O estoque não pode ser negativo.");
        if(request.name() == null || request.name().isBlank()) throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        if(request.minimumStock() < 0) throw new IllegalArgumentException("O estoque mínimo não pode ser negativo.");
        if(request.price().compareTo(BigDecimal.ZERO) == -1) throw new IllegalArgumentException("O preço do produto não pode ser negativo.");
        
        String barCode = generateUniqueBarcode(request.category());
        
        productRepository.save(
            new Product(
                request.name(),
                request.description(),
                request.stock(), 
                request.minimumStock(), 
                request.category(), 
                request.price(),
                barCode
            )
        );
    }

    @Override
    public void updateProductByUuid(UUID productUuid, ProductUpdateDtoRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProductByUuid'");
    }

    @Override
    public ProductFindDetailsDtoResponse getProductByUuid(UUID productUuid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductByUuid'");
    }

    @Override
    public ProductSearchDtoResponse getProductByBarcode(String barcode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductByBarcode'");
    }

    @Override
    public List<ProductSearchDtoResponse> getProductByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductByName'");
    }

    @Override
    public void deleteProductByUuid(UUID productUuid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProductByUuid'");
    }


    private String generateUniqueBarcode(ProductCategories category) {
        String barCode;
        int attempts = 0;
        do {
            if (attempts++ > 10) {
                throw new ExcededAttmptsException("Código de Barra");
            }
            barCode = BarcodeUtils.generateBarcode(category);
        } while (productRepository.existsByBarcode(barCode));
        return barCode;
    }
    
}
