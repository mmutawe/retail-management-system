package com.mmutawe.projects.ms.retail.inventory.services;

import com.mmutawe.projects.ms.retail.inventory.dtos.InventoryAvailabilityResponseDto;
import com.mmutawe.projects.ms.retail.inventory.dtos.InventoryListAvailabilityRequestDto;
import com.mmutawe.projects.ms.retail.inventory.dtos.InventoryListAvailabilityResponseDto;
import org.springframework.transaction.annotation.Transactional;

public interface InventoryService {

    @Transactional(readOnly = true)
    InventoryAvailabilityResponseDto checkAvailabilityBySkuCode(String skuCode);

    InventoryListAvailabilityResponseDto checkListAvailabilityBySkuCodes(InventoryListAvailabilityRequestDto inventoryListAvailabilityRequestDto);
}
