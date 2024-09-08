package com.stock_manager.stock_manager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stock_manager.stock_manager.dto.request.SellerCreateDtoRequest;
import com.stock_manager.stock_manager.dto.request.SellerUpdateDtoRequest;
import com.stock_manager.stock_manager.dto.response.SellerCreatedResponse;
import com.stock_manager.stock_manager.dto.response.SellerDetailsDtoResponse;
import com.stock_manager.stock_manager.service.SellerService;

import jakarta.validation.Valid;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/sellers")
@CrossOrigin(origins = "*")
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SellerCreatedResponse newSeller(@RequestBody @Valid SellerCreateDtoRequest request) {
        return this.sellerService.createNewSeller(request);
    }

    @GetMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public SellerDetailsDtoResponse getSellerByUuid(@PathVariable UUID uuid) {
        return sellerService.getSellerByUuid(uuid);
    }

    @PutMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSellerByUuid(@PathVariable UUID uuid, @RequestBody SellerUpdateDtoRequest request) {
        sellerService.updateSellerByUuid(uuid, request);
    }    

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSellerByUuid(@PathVariable UUID uuid) {
        sellerService.deactivateSellerByUuid(uuid);
    }    
}
