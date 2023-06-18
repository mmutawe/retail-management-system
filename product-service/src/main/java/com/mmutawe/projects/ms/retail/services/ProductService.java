package com.mmutawe.projects.ms.retail.services;

import com.mmutawe.projects.ms.retail.dtos.ProductListResponseDto;
import com.mmutawe.projects.ms.retail.dtos.ProductRequestDto;

public interface ProductService {

    Integer createProduct(ProductRequestDto productRequestDto);

    ProductListResponseDto getAllProducts();
}
