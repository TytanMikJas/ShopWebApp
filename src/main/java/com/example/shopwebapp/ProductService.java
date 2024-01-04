package com.example.shopwebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
//    ArrayList<Product> productList = new ArrayList<>();

    public ProductService() {
    }

    public void seed() {
        Product prod1 = Product.builder()
                .id(1)
                .productName("Chleb")
                .weight(0.15)
                .price(1.21)
                .build();

        Product prod2 = Product.builder()
                .id(2)
                .productName("Masło")
                .weight(0.2)
                .price(3.14)
                .build();

        Product prod3 = Product.builder()
                .id(3)
                .productName("Kiełbasa")
                .weight(0.5)
                .price(21.15)
                .build();

        productRepository.save(prod1);
        productRepository.save(prod2);
        productRepository.save(prod3);
    }

    private boolean isEmpty() {
        return productRepository.count() == 0;
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductById(long id) {
        var value = productRepository.findById(id);
        return value.orElse(null);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.deleteById(product.getId());
    }

    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }
}
