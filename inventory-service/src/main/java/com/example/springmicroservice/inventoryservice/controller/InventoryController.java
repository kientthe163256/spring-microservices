package com.example.springmicroservice.inventoryservice.controller;

import com.example.springmicroservice.inventoryservice.dto.InventoryResponse;
import com.example.springmicroservice.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    //http.../api/inventory/?sku-code=iphone-13&sku-code=samsung-s22
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam("sku-code") List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
