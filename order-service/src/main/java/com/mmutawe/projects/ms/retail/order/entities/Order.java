package com.mmutawe.projects.ms.retail.order.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_number")
    private UUID orderNumber;

//    @OneToMany(mappedBy="orders", cascade = CascadeType.ALL)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_item",
            joinColumns = @JoinColumn(name = "order_number"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<OrderItem> orderItems;
}
