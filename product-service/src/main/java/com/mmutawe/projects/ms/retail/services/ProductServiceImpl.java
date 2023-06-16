package com.mmutawe.projects.ms.retail.services;

import com.mmutawe.projects.ms.retail.dtos.ProductRequestDto;
import com.mmutawe.projects.ms.retail.entities.Product;
import com.mmutawe.projects.ms.retail.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Integer createProduct(ProductRequestDto productRequestDto) {

        Product product = Product.builder()
                .name(productRequestDto.getName())
                .description(productRequestDto.getDescription())
                .price(productRequestDto.getPrice())
                .build();

        productRepository.save(product);
        log.debug("*** Product with Id '{}' is saved", product.getId());
        return product.getId();
    }
}
