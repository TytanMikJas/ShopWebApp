package com.example.shopwebapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private String productName;

    private double weight;

    private double price;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
}
