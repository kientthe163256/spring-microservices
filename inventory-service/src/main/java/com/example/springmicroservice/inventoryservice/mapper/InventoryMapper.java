package com.example.springmicroservice.inventoryservice.mapper;

import com.example.springmicroservice.inventoryservice.dto.InventoryResponse;
import com.example.springmicroservice.inventoryservice.model.Inventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class InventoryMapper {
    public InventoryResponse mapToInventoryResponse(Inventory inventory){
        return InventoryResponse.builder()
                .skuCode(inventory.getSkuCode())
                .isInStock(inventory.getQuantity() > 0)
                .build();
    }
}
