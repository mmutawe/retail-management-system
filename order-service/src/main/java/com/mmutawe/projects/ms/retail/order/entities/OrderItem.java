package com.mmutawe.projects.ms.retail.order.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer id;

    @Column(name = "sku_code")
    private String skuCode;

    private Integer quantity;
    private BigDecimal price;

    @Transient
    @ManyToMany(mappedBy = "orderItems")
    private Set<Order> orders;
}
