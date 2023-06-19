package com.mmutawe.projects.ms.retail.inventory.controllers;

import com.mmutawe.projects.ms.retail.inventory.dtos.InventoryAvailabilityResponseDto;
import com.mmutawe.projects.ms.retail.inventory.services.InventoryService;
import com.mmutawe.projects.ms.retail.inventory.utils.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.mmutawe.projects.ms.retail.inventory.utils.Constant.*;

@RestController
@RequestMapping(INVENTORY_URI)
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping(SKU_CODE_PATH)
    public ResponseEntity<InventoryAvailabilityResponseDto> checkAvailabilityInStick(@PathVariable String skuCode){
        InventoryAvailabilityResponseDto inventoryAvailabilityResponseDto = inventoryService
                .checkAvailabilityBySkuCode(skuCode);

        return ResponseEntity
                .ok(inventoryAvailabilityResponseDto);
    }
}
