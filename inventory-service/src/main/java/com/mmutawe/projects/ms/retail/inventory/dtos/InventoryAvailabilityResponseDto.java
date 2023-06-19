package com.mmutawe.projects.ms.retail.inventory.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryAvailabilityResponseDto {

    @JsonProperty("is_in_stock")
    private Boolean isInStock;
}
