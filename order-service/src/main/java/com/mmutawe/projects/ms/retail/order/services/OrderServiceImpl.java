package com.mmutawe.projects.ms.retail.order.services;

import com.mmutawe.projects.ms.retail.order.dtos.*;
import com.mmutawe.projects.ms.retail.order.entities.Order;
import com.mmutawe.projects.ms.retail.order.entities.OrderItem;
import com.mmutawe.projects.ms.retail.order.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    @Value("${retail-ms.inventory-api.url}")
    private String inventoryUrl;

    @Override
    public OrderResponseDto placingOrder(OrderRequestDto orderRequestDto) {

        List<String> skuCodes = orderRequestDto.getOrderItems().stream()
                .map(OrderItemVO::getSkuCode)
                .toList();

        InventoryListAvailabilityRequestDto inventoryListAvailabilityRequestDto = InventoryListAvailabilityRequestDto.builder()
                .skuCodes(skuCodes)
                .build();
        // check item availability
        InventoryListAvailabilityResponseDto inventoryListAvailabilityResponseDto = webClientBuilder.build()
                .post()
                .uri(inventoryUrl)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(inventoryListAvailabilityRequestDto)
                .retrieve()
                .bodyToMono(InventoryListAvailabilityResponseDto.class)
                .block();

        // block order if any of the items is not available
        boolean hasUnavailableitem = inventoryListAvailabilityResponseDto.getInventoryAvailabilityVOs()
                .stream()
                .anyMatch(inv -> inv.getQuantity() == 0);
        if(hasUnavailableitem) {
            throw new RuntimeException("Some of the item is not available in stock.");
        }

        // place order if available
        Order order = Order.builder()
                .orderItems(mapToOrderItemSet(orderRequestDto))
                .build();
        orderRepository.save(order);

        log.debug("order has placed successfully.");
        return OrderResponseDto.builder()
                .orderNumber(order.getOrderNumber())
                .build();
    }

    private Set<OrderItem> mapToOrderItemSet(OrderRequestDto orderRequestDto) {
        return orderRequestDto.getOrderItems().stream()
                .map(this::mapToOrderItem)
                .collect(Collectors.toSet());
    }

    private OrderItem mapToOrderItem(OrderItemVO orderItemVO) {
        return OrderItem.builder()
                .skuCode(orderItemVO.getSkuCode())
                .quantity(orderItemVO.getQuantity())
                .price(orderItemVO.getPrice())
                .build();
    }
}
