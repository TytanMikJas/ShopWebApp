package com.example.shopwebapp.service;

import com.example.shopwebapp.entity.Category;
import com.example.shopwebapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public CategoryService() {
    }

    public void seed() {
        Category cat1 = Category.builder()
                .id(1)
                .categoryName("Pieczywo")
                .code("P")
                .build();

        Category cat2 = Category.builder()
                .id(2)
                .categoryName("Mięso")
                .code("M")
                .build();

        Category cat3 = Category.builder()
                .id(3)
                .categoryName("Nabiał")
                .code("N")
                .build();

        categoryRepository.save(cat1);
        categoryRepository.save(cat2);
        categoryRepository.save(cat3);
    }

    private boolean isEmpty() {
        return categoryRepository.count() == 0;
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category getCategoryById(long id) {
        var value = categoryRepository.findById(id);
        return value.orElse(null);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Category category) {
        categoryRepository.deleteById(category.getId());
    }

    public void deleteCategoryById(long id) {
        categoryRepository.deleteById(id);
    }
}
