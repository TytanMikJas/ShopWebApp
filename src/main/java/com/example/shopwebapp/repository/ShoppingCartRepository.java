package com.example.shopwebapp.repository;

import com.example.shopwebapp.entity.Product;
import com.example.shopwebapp.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

}
