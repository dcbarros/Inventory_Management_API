package com.stock_manager.stock_manager.service;

import java.util.UUID;

import com.stock_manager.stock_manager.dto.request.ItemCreateDtoRequest;
import com.stock_manager.stock_manager.dto.request.ItemUpdateDtoRequest;
import com.stock_manager.stock_manager.dto.response.ItemDetailsResponse;

public interface ItemService {
    public void createNewItem(ItemCreateDtoRequest request);
    public void updateItemByUuid(UUID itemUuid, ItemUpdateDtoRequest request);
    public ItemDetailsResponse getItemByUuid(UUID itemUuid);
    public void deleteItemByUuid(UUID itemUuid);
}
