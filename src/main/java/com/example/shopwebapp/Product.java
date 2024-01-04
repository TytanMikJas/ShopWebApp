package com.example.shopwebapp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    private long id;
    private String productName;
    private double weight;
    private double price;
}
