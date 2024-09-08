package com.stock_manager.stock_manager.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stock_manager.stock_manager.dto.request.ProductCreateDtoRequest;
import com.stock_manager.stock_manager.dto.response.ProductFindDetailsDtoResponse;
import com.stock_manager.stock_manager.dto.response.ProductSearchDtoResponse;
import com.stock_manager.stock_manager.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "*")
public class ProductController {
    
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewProduct(@RequestBody ProductCreateDtoRequest request) {
        productService.createNewProduct(request);
    }

    @GetMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public ProductFindDetailsDtoResponse getProductByUuid(@PathVariable UUID uuid) {
        return productService.getProductByUuid(uuid);
    }
    
    @GetMapping("/barcode/{barcode}")
    @ResponseStatus(HttpStatus.OK)
    public ProductSearchDtoResponse getMethodName(@PathVariable String barcode) {
        return productService.getProductByBarcode(barcode);
    }
    
}
