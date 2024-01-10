package com.example.shopwebapp.controller;

import com.example.shopwebapp.entity.Product;
import com.example.shopwebapp.entity.ShoppingCart;
import com.example.shopwebapp.service.ProductService;
import com.example.shopwebapp.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class ShopItemController {
    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;

    public ShopItemController(ProductService productService, ShoppingCartService shoppingCartService) {
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
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

    @GetMapping("/shopItem/add")
    public String add(Model model) {
        model.addAttribute("shoppingCart", new ShoppingCart());
        model.addAttribute("categoryOptions", productService.getCategoryOptions());
        return "shopItem/add";
    }

    @PostMapping("/shopItem/add")
    public String add(@ModelAttribute Product product) {
        // TODO: replace with shoppingCartService:
        shoppingCartService.addProduct(product);
        return "redirect:/cart/";
    }
}
