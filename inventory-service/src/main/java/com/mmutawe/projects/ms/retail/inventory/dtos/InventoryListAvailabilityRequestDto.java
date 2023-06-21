package com.mmutawe.projects.ms.retail.inventory.dtos;

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
public class InventoryListAvailabilityRequestDto {

    @JsonProperty("sku_code")
    List<String> skuCodes;
}
