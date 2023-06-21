package com.mmutawe.projects.ms.retail.inventory.services;

import com.mmutawe.projects.ms.retail.inventory.dtos.InventoryAvailabilityResponseDto;
import com.mmutawe.projects.ms.retail.inventory.dtos.InventoryAvailabilityVO;
import com.mmutawe.projects.ms.retail.inventory.dtos.InventoryListAvailabilityRequestDto;
import com.mmutawe.projects.ms.retail.inventory.dtos.InventoryListAvailabilityResponseDto;
import com.mmutawe.projects.ms.retail.inventory.entities.Inventory;
import com.mmutawe.projects.ms.retail.inventory.repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public InventoryListAvailabilityResponseDto checkListAvailabilityBySkuCodes(InventoryListAvailabilityRequestDto inventoryListAvailabilityRequestDto) {

        Optional<List<Inventory>> optionalInventories = inventoryRepository
                .findBySkuCodeIn(inventoryListAvailabilityRequestDto.getSkuCodes());

        return InventoryListAvailabilityResponseDto.builder()
                .inventoryAvailabilityVOs(mapToListInventoryAvailabilityVO(optionalInventories.orElseThrow(RuntimeException::new)))
                .build();
    }

    private List<InventoryAvailabilityVO> mapToListInventoryAvailabilityVO(List<Inventory> inventories) {

        return inventories.stream()
                .map(this::mapToInventoryAvailabilityVO)
                .toList();
    }

    private InventoryAvailabilityVO mapToInventoryAvailabilityVO(Inventory inventory) {

        return InventoryAvailabilityVO.builder()
                .skuCode(inventory.getSkuCode())
                .quantity(inventory.getQuantity())
                .build();
    }

}
