package com.ecommerceMicro.inventoryService.controllers;

import com.ecommerceMicro.inventoryService.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode , @RequestParam Integer quantity){
        return inventoryService.isInStock(skuCode, quantity);

    }

    @PutMapping("/reduce")
    public ResponseEntity<Void> reduceInventory(
            @RequestParam String skuCode,
            @RequestParam Integer quantity
    ){
        inventoryService.reduceInventory(skuCode,quantity);
        return ResponseEntity.ok().build();
    }
}
