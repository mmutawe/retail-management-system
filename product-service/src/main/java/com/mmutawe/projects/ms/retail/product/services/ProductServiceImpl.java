package com.mmutawe.projects.ms.retail.product.services;

import com.mmutawe.projects.ms.retail.product.dtos.ProductListResponseDto;
import com.mmutawe.projects.ms.retail.product.dtos.ProductRequestDto;
import com.mmutawe.projects.ms.retail.product.dtos.ProductResponseDto;
import com.mmutawe.projects.ms.retail.product.entities.Product;
import com.mmutawe.projects.ms.retail.product.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public ProductListResponseDto getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        return mapToProductListResponseDto(allProducts);
    }

    private ProductResponseDto maptoProductResponseDto(Product product){
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    private ProductListResponseDto mapToProductListResponseDto(List<Product> allProducts) {
        List<ProductResponseDto> productsDtos = allProducts.stream()
                .map(this::maptoProductResponseDto)
                .toList();

        return ProductListResponseDto.builder()
                .productList(productsDtos)
                .build();
    }
}
