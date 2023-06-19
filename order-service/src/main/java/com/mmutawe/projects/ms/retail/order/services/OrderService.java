package com.mmutawe.projects.ms.retail.order.services;

import com.mmutawe.projects.ms.retail.order.dtos.OrderRequestDto;
import com.mmutawe.projects.ms.retail.order.dtos.OrderResponseDto;

public interface OrderService {
    OrderResponseDto placingOrder(OrderRequestDto orderRequestDto);
}
