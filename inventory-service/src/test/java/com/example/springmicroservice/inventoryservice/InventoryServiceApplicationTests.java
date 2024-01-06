package com.example.springmicroservice.inventoryservice;

import com.example.springmicroservice.inventoryservice.model.Inventory;
import com.example.springmicroservice.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class InventoryServiceApplicationTests {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Test
    public void getInventoryNonExist(){
        List<Inventory> inventoryList = inventoryRepository.findBySkuCodeIn(List.of("non_exist"));
        Assertions.assertEquals(0, inventoryList.size());
    }
}
