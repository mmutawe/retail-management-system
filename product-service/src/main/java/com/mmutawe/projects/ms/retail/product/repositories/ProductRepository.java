package com.mmutawe.projects.ms.retail.product.repositories;

import com.mmutawe.projects.ms.retail.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
