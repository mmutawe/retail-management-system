package com.mmutawe.projects.ms.retail.repositories;

import com.mmutawe.projects.ms.retail.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
