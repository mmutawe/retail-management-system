package com.mmutawe.projects.ms.retail.order.controllers;

import com.mmutawe.projects.ms.retail.order.dtos.OrderRequestDto;
import com.mmutawe.projects.ms.retail.order.dtos.OrderResponseDto;
import com.mmutawe.projects.ms.retail.order.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.mmutawe.projects.ms.retail.order.utils.Constant.ORDER_URI;

@RestController
@RequestMapping(ORDER_URI)
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDto> placeOrder(@RequestBody OrderRequestDto orderRequestDto){
        OrderResponseDto orderResponseDto = orderService.placingOrder(orderRequestDto);

        return ResponseEntity
                .ok(orderResponseDto);
    }
}
