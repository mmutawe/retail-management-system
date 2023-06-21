package com.mmutawe.projects.ms.retail.order.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryAvailabilityVO {
    @JsonProperty("sku_code")
    private String skuCode;
    private Integer quantity;
}
