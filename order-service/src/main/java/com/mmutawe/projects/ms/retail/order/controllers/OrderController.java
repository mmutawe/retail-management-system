package com.mmutawe.projects.ms.retail.order.controllers;

import com.mmutawe.projects.ms.retail.order.dtos.OrderRequestDto;
import com.mmutawe.projects.ms.retail.order.dtos.OrderResponseDto;
import com.mmutawe.projects.ms.retail.order.services.OrderService;
import com.mmutawe.projects.ms.retail.order.utils.Constant;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.mmutawe.projects.ms.retail.order.utils.Constant.*;

@RestController
@RequestMapping(ORDER_URI)
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @Retry(name = RESILIENCE4J_INSTANCE_INVENTORY)
    @TimeLimiter(name = RESILIENCE4J_INSTANCE_INVENTORY)
    @CircuitBreaker(
            name = "inventory",
            fallbackMethod = INVENTORY_FALLBACK_METHOD_NAME)
    public Mono<ResponseEntity<OrderResponseDto>> placeOrder(@RequestBody OrderRequestDto orderRequestDto) {
        OrderResponseDto orderResponseDto = orderService.placingOrder(orderRequestDto);

        return Mono.fromSupplier(() -> ResponseEntity.ok(orderResponseDto));
    }

    private Mono<ResponseEntity<Object>> inventoryServiceUnresponsiveFallBack(
            OrderRequestDto orderRequestDto,
            RuntimeException runtimeException) {
        return Mono.fromSupplier(() -> ResponseEntity
                        .status(HttpStatus.SERVICE_UNAVAILABLE)
                        .body("inventory-api is unable to handle order-api requests!"));
    }

}
