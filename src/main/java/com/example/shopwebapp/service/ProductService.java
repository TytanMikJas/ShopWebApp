package com.example.shopwebapp.service;

import com.example.shopwebapp.entity.Category;
import com.example.shopwebapp.entity.Product;
import com.example.shopwebapp.optionModel.IdStringModel;
import com.example.shopwebapp.repository.CategoryRepository;
import com.example.shopwebapp.repository.ProductRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

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

    public List<IdStringModel> getCategoryOptions() {
        List<IdStringModel> result = new ArrayList<>();
        result.add(new IdStringModel(0, "---"));
        List<Category> categoryList = categoryRepository.findAll();
        for (Category category : categoryList) {
            result.add(new IdStringModel(category.getId(), category.getCategoryName()));
        }
        return result;
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
