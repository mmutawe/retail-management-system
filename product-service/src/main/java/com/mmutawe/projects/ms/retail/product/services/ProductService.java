package com.mmutawe.projects.ms.retail.product.services;

import com.mmutawe.projects.ms.retail.product.dtos.ProductListResponseDto;
import com.mmutawe.projects.ms.retail.product.dtos.ProductRequestDto;

public interface ProductService {

    Integer createProduct(ProductRequestDto productRequestDto);

    ProductListResponseDto getAllProducts();
}
