package com.example.shopwebapp;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    ArrayList<Product> productList = new ArrayList<>();

    public ProductService() {}

    public void seed(){
    productList.add(new Product(1,"Chleb", 0.15, 1.21));
    productList.add(new Product(2,"Malso", 0.2, 3.14));
    productList.add(new Product(3,"Kiełbasa", 0.5, 21.15));
    }

    private boolean isEmpty() {
        return productList.isEmpty();
    }

    public List<Product> getAllProduct() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Product getProductById(long id) {
        for(Product product:productList){
            if(product.getId()==id)
                return product;
        }
        return null;
    }

    public void updateProduct(Product product) {
        deleteProduct(product);
        productList.add(product);
    }

    public void deleteProduct(Product product) {
        productList.remove(getProductById(product.getId()));
    }

    public void deleteProductById(long id) {
        productList.remove(getProductById(id));
    }
}
