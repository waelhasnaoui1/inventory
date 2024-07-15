package com.ecommerceMicro.inventoryService.repostiories;

import com.ecommerceMicro.inventoryService.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode ,int quantity);

}
