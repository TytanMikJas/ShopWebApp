package com.example.shopwebapp.service;

import com.example.shopwebapp.entity.Product;
import com.example.shopwebapp.entity.ShoppingCart;
import com.example.shopwebapp.repository.CategoryRepository;
import com.example.shopwebapp.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public ShoppingCartService() {
    }

    private boolean isEmpty() {
        return shoppingCartRepository.count() == 0;
    }

    public List<ShoppingCart> getAllShoppingCartItems() {
        return shoppingCartRepository.findAll();
    }

    public void addProduct(Product product) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setProductName(product.getProductName());
        shoppingCart.setWeight(product.getWeight());
        shoppingCart.setPrice(product.getPrice());
        shoppingCart.setCategory(product.getCategory());

        shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart getProductById(long id) {
        var value = shoppingCartRepository.findById(id);
        return value.orElse(null);
    }

    public void updateProduct(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
    }

    public void deleteProduct(Product product) {
        shoppingCartRepository.deleteById(product.getId());
    }

    public void deleteProductById(long id) {
        shoppingCartRepository.deleteById(id);
    }
}
