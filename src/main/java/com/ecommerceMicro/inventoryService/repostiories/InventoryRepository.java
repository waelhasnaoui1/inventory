package com.ecommerceMicro.inventoryService.repostiories;

import com.ecommerceMicro.inventoryService.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode ,int quantity);


    Optional<Inventory> findBySkuCode(String skuCode);
}
