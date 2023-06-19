package com.mmutawe.projects.ms.retail.product.controllers;

import com.mmutawe.projects.ms.retail.product.dtos.ProductListResponseDto;
import com.mmutawe.projects.ms.retail.product.dtos.ProductRequestDto;
import com.mmutawe.projects.ms.retail.product.services.ProductService;
import com.mmutawe.projects.ms.retail.product.utils.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(Constant.PRODUCT_URI)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> createNewProduct(@RequestBody ProductRequestDto productRequestDto) {
        Integer createdProductId = productService
                .createProduct(productRequestDto);
        return ResponseEntity
                .created(URI.create(Constant.PRODUCT_URI + Constant.SLASH + createdProductId))
                .build();
    }

    @GetMapping
    public ResponseEntity<ProductListResponseDto> retrieveAllProducts() {
        return ResponseEntity
                .ok(productService.getAllProducts());
    }
}
