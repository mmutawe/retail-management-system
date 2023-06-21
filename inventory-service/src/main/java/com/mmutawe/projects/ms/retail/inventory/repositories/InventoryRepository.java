package com.mmutawe.projects.ms.retail.inventory.repositories;

import com.mmutawe.projects.ms.retail.inventory.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    Boolean existsBySkuCode(String skuCode);

    Optional<List<Inventory>> findBySkuCodeIn(List<String> skuCodes);
}
