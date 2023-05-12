package com.example.springmicroservice.inventoryservice.service;

import com.example.springmicroservice.inventoryservice.dto.InventoryResponse;
import com.example.springmicroservice.inventoryservice.mapper.InventoryMapper;
import com.example.springmicroservice.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode){
//        log.info("Wait started");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        log.info("Wait ended");
        return inventoryRepository.findBySkuCodeIn(skuCode)
                .stream()
                .map(inventoryMapper::mapToInventoryResponse)
                .toList();
    }
}
