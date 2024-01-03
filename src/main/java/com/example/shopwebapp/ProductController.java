package com.example.shopwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/")
    public String home(Locale locale, Model model) {
        Date date = new Date();
        DateFormat dateFromat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);
        String serverTime = dateFromat.format(date);
        model.addAttribute("serverTime", serverTime);
        List<Product> productList = productService.getAllProduct();
        model.addAttribute("productList", productList);

        return "product/index";
    }


    @GetMapping("/product/seed")
    public String seed() {
        productService.seed();
        return "redirect:/product/";
    }

    @GetMapping("/product/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "product/add";
    }

    @PostMapping("/product/add")
    public String add(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/product/";
    }

    @GetMapping("/product/details/{id}")
    public String details(@PathVariable("id") long inputId, Model model) {
        model.addAttribute("product", productService.getProductById(inputId));
        return "product/details";
    }


    @GetMapping(value = {"/product/{prodId}/edit"})
    public String edit(Model model, @PathVariable("prodId") long prodId) {
        model.addAttribute("product", productService.getProductById(prodId));
        return "product/edit";
    }


    @PostMapping(value = {"/product/edit"})
    public String edit(@ModelAttribute Product product) {
        productService.updateProduct(product);
        return "redirect:/product/";
    }

    @GetMapping("/product/remove")
    public String delete(@RequestParam("id") long inputId) {
        productService.deleteProductById(inputId);
        return "redirect:/product/";
    }

}
