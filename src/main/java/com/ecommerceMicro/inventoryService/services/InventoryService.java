package com.ecommerceMicro.inventoryService.services;

import com.ecommerceMicro.inventoryService.Model.Inventory;
import com.ecommerceMicro.inventoryService.repostiories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly =true)
    public boolean isInStock(String skuCode, Integer quantity){
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode,quantity);
    }

    @Transactional()
    public void reduceInventory(String skuCode,Integer quantity){
        System.out.println("the sku code is");
        System.out.println(skuCode);
        Inventory inventory =
                inventoryRepository
                        .findBySkuCode(skuCode).orElseThrow(
                                () -> new RuntimeException("Sku code not found")
                        );

        if(inventory.getQuantity() < quantity){
            throw new RuntimeException("Insufficient quantity in inventory");
        }
        inventory.setQuantity(inventory.getQuantity()-quantity);
        inventoryRepository.save(inventory);
    }
}
