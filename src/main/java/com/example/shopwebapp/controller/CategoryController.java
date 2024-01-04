package com.example.shopwebapp.controller;

import com.example.shopwebapp.entity.Category;
import com.example.shopwebapp.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category/")
    public String home(Locale locale, Model model) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);
        String serverTime = dateFormat.format(date);
        model.addAttribute("serverTime", serverTime);
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList", categoryList);

        return "category/index";
    }

    @GetMapping("/category/seed")
    public String seed() {
        categoryService.seed();
        return "redirect:/category/";
    }

    @GetMapping("/category/add")
    public String add(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @PostMapping("/category/add")
    public String add(@ModelAttribute Category category) {
        categoryService.addCategory(category);
        return "redirect:/category/";
    }

    @GetMapping("/category/details/{id}")
    public String details(@PathVariable("id") long inputId, Model model) {
        model.addAttribute("category", categoryService.getCategoryById(inputId));
        return "category/details";
    }


    @GetMapping(value = {"/category/{prodId}/edit"})
    public String edit(Model model, @PathVariable("prodId") long prodId) {
        model.addAttribute("category", categoryService.getCategoryById(prodId));
        return "category/edit";
    }


    @PostMapping(value = {"/category/edit"})
    public String edit(@ModelAttribute Category category) {
        categoryService.updateCategory(category);
        return "redirect:/category/";
    }

    @GetMapping("/category/remove")
    public String delete(@RequestParam("id") long inputId) {
        categoryService.deleteCategoryById(inputId);
        return "redirect:/category/";
    }
}
