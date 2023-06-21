package com.mmutawe.projects.ms.retail.order.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryListAvailabilityResponseDto {

    @JsonProperty("all_inventory_availability")
    private List<InventoryAvailabilityVO> inventoryAvailabilityVOs;
}
