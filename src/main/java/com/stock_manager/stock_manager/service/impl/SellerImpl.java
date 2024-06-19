package com.stock_manager.stock_manager.service.impl;

import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stock_manager.stock_manager.dto.request.SellerCreateDtoRequest;
import com.stock_manager.stock_manager.dto.request.SellerUpdateDtoRequest;
import com.stock_manager.stock_manager.dto.response.SellerDetailsDtoResponse;
import com.stock_manager.stock_manager.model.Seller;
import com.stock_manager.stock_manager.repository.SellerRepository;
import com.stock_manager.stock_manager.service.SellerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SellerImpl implements SellerService{

    private final SellerRepository sellerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createNewSeller(SellerCreateDtoRequest request) {
        if(request.email() == null || request.email().isBlank()){
            throw new IllegalArgumentException("email");
        }
        if(request.name() == null || request.name().isBlank()){
            throw new IllegalArgumentException("name");
        }
        if(request.password() == null || request.password().isBlank()){
            throw new IllegalArgumentException("password");
        }
        
        Seller seller = new Seller(request.name(), request.email(), this.passwordEncoder.encode(request.password()));
        sellerRepository.save(seller);
    }

    @Override
    public void updateSellerByUuid(UUID sellerUuid, SellerUpdateDtoRequest request) {

    }

    @Override
    public SellerDetailsDtoResponse getSellerByUuid(UUID sellerUuid) {
        return null;
    }

    @Override
    public void deleteSellerByUuid(UUID sellerUuid) {

    }
    
}
