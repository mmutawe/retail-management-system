package com.mmutawe.projects.ms.retail.inventory.services;

import com.mmutawe.projects.ms.retail.inventory.dtos.InventoryAvailabilityResponseDto;
import com.mmutawe.projects.ms.retail.inventory.repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{

    private final InventoryRepository inventoryRepository;

    @Override
    public InventoryAvailabilityResponseDto checkAvailabilityBySkuCode(String skuCode) {

        Boolean isInStock = inventoryRepository.existsBySkuCode(skuCode);
        return InventoryAvailabilityResponseDto.builder()
                .isInStock(isInStock)
                .build();
    }
}
