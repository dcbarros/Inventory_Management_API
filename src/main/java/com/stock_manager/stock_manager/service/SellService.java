package com.stock_manager.stock_manager.service;

import java.util.List;
import java.util.UUID;

import com.stock_manager.stock_manager.dto.request.SellCreateDtoRequest;
import com.stock_manager.stock_manager.dto.request.SellUpdateDtoRequest;
import com.stock_manager.stock_manager.dto.response.SellDetailsDtoResponse;
import com.stock_manager.stock_manager.model.Item;

public interface SellService {
    public void createNewSell(SellCreateDtoRequest request);
    public void addItens(UUID sellUuid, List<Item> itens);
    public void updateSellByUuid(UUID sellUuid, SellUpdateDtoRequest request);
    public SellDetailsDtoResponse getSellByUuid(UUID sellUuid);
    public List<SellDetailsDtoResponse> getAllSellBySellerUuid(UUID sellerUuid);
    public void payment(UUID sellUuid);
}
