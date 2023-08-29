package com.tcs.ordermanagement.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;
    private int quantity;
}