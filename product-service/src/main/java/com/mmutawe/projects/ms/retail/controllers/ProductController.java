package com.mmutawe.projects.ms.retail.controllers;

import com.mmutawe.projects.ms.retail.dtos.ProductRequestDto;
import com.mmutawe.projects.ms.retail.services.ProductService;
import com.mmutawe.projects.ms.retail.utils.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static com.mmutawe.projects.ms.retail.utils.Constant.*;

@RestController
@RequestMapping(PRODUCT_URI)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createNewProduct(@RequestBody ProductRequestDto productRequestDto){
        Integer createdProductId = productService
                .createProduct(productRequestDto);
        return ResponseEntity
                .created(URI.create(PRODUCT_URI + SLASH + createdProductId))
                .build();
    }
}
