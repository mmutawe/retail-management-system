package com.mmutawe.projects.ms.retail.inventory.services;

import com.mmutawe.projects.ms.retail.inventory.dtos.InventoryAvailabilityResponseDto;
import org.springframework.transaction.annotation.Transactional;

public interface InventoryService {

    @Transactional(readOnly = true)
    InventoryAvailabilityResponseDto checkAvailabilityBySkuCode(String skuCode);
}
