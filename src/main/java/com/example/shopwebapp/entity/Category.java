package com.example.shopwebapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private String categoryName;

    private String code;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> products = new ArrayList<>();
}
