package com.mmutawe.projects.ms.retail.inventory.controllers;

import com.mmutawe.projects.ms.retail.inventory.dtos.InventoryListAvailabilityRequestDto;
import com.mmutawe.projects.ms.retail.inventory.dtos.InventoryListAvailabilityResponseDto;
import com.mmutawe.projects.ms.retail.inventory.dtos.InventoryAvailabilityResponseDto;
import com.mmutawe.projects.ms.retail.inventory.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<InventoryListAvailabilityResponseDto> checkListAvailabilityInStick(@RequestBody InventoryListAvailabilityRequestDto inventoryListAvailabilityRequestDto){
        InventoryListAvailabilityResponseDto inventoryListAvailabilityResponseDto = inventoryService
                .checkListAvailabilityBySkuCodes(inventoryListAvailabilityRequestDto);

        return ResponseEntity
                .ok(inventoryListAvailabilityResponseDto);
    }

}
