package com.mmutawe.projects.ms.retail.order.repositories;

import com.mmutawe.projects.ms.retail.order.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
}
