package com.mmutawe.projects.ms.retail.inventory.repositories;

import com.mmutawe.projects.ms.retail.inventory.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    Boolean existsBySkuCode(String skuCode);
}
