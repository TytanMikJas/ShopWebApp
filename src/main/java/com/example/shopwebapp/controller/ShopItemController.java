package com.example.shopwebapp.controller;

import com.example.shopwebapp.entity.Product;
import com.example.shopwebapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class ShopItemController {
    private final ProductService productService;

    public ShopItemController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/shop/")
    public String home(Locale locale, Model model) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);
        String serverTime = dateFormat.format(date);
        model.addAttribute("serverTime", serverTime);
        List<Product> productList = productService.getAllProduct();
        model.addAttribute("productList", productList);

        return "shopItem/index";
    }
}
