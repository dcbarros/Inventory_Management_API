package com.stock_manager.stock_manager.service.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

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
        Seller seller = sellerRepository.findByUuid(sellerUuid)
                        .orElseThrow(() -> new NotFoundException("Vendedor com o UUID " + sellerUuid + " não encontrado"));

        if(request.email() == null || request.email().isBlank()){
            throw new IllegalArgumentException("email");
        }
        if(request.name() == null || request.name().isBlank()){
            throw new IllegalArgumentException("name");
        }
        if(request.newPassword() == null || request.newPassword().isBlank()){
            throw new IllegalArgumentException("password");
        }

        boolean isUpdated = false;

        if (!seller.getEmail().equals(request.email())) {
            seller.setEmail(request.email());
            isUpdated = true;
        }
        if (!seller.getName().equals(request.name())) {
            seller.setName(request.name());
            isUpdated = true;
        }
        String encodedPassword = passwordEncoder.encode(request.newPassword());
        if (!seller.getPassword().equals(encodedPassword)) {
            seller.setPassword(encodedPassword);
            isUpdated = true;
        }
    
        if (isUpdated) {
            sellerRepository.save(seller);
        }
    }
    
    @Override
    public SellerDetailsDtoResponse getSellerByUuid(UUID sellerUuid) {
        Seller seller = sellerRepository.findByUuid(sellerUuid)
                        .orElseThrow(() -> new NotFoundException("Vendedor com o UUID " + sellerUuid + " não encontrado"));
        return new SellerDetailsDtoResponse(sellerUuid, seller.getName(), seller.getEmail(), seller.getSells());
    }

    @Override
    public void deactivateSellerByUuid(UUID sellerUuid) {
        
        Seller seller = sellerRepository.findByUuid(sellerUuid)
                        .orElseThrow(() -> new NotFoundException("Vendedor com o UUID " + sellerUuid + " não encontrado"));
        if(!seller.getIsActive()){
            throw new IllegalStateException("O Vendedor já está desativado");
        }

        seller.setIsActive(false);
        seller.setDeleteAt(LocalDateTime.now());
        sellerRepository.save(seller);
    }
    
}
