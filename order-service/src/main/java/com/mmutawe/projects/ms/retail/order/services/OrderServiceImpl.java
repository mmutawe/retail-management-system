package com.mmutawe.projects.ms.retail.order.services;

import com.mmutawe.projects.ms.retail.order.dtos.OrderItemVO;
import com.mmutawe.projects.ms.retail.order.dtos.OrderRequestDto;
import com.mmutawe.projects.ms.retail.order.dtos.OrderResponseDto;
import com.mmutawe.projects.ms.retail.order.entities.Order;
import com.mmutawe.projects.ms.retail.order.entities.OrderItem;
import com.mmutawe.projects.ms.retail.order.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderResponseDto placingOrder(OrderRequestDto orderRequestDto) {

        Order order = Order.builder()
                .orderItems(mapToOrderItemSet(orderRequestDto))
                .build();
        orderRepository.save(order);

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
