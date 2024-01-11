package com.example.shopwebapp.controller;

import com.example.shopwebapp.entity.Category;
import com.example.shopwebapp.entity.Product;
import com.example.shopwebapp.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.util.ArrayList;
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

    @GetMapping("/cart/")
    public String home2(Model model, HttpServletRequest request) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.getDefault());
        String serverTime = dateFormat.format(date);
        model.addAttribute("serverTime", serverTime);

        @SuppressWarnings("unchecked")
        List<Product> shoppingCartList = (List<Product>) request.getSession().getAttribute("SHOPPING_CART");

        if (shoppingCartList == null) {
            shoppingCartList = new ArrayList<>();
            request.getSession().setAttribute("SHOPPING_CART", shoppingCartList);
        }

        model.addAttribute("shoppingCartList", shoppingCartList);

        return "shoppingCart/index";
    }

    @GetMapping("/shopItem/add")
    public String add(@RequestParam("productId") long productId, Model model, HttpServletRequest request) {
        // model.addAttribute("shoppingCart", new ShoppingCart());
        // model.addAttribute("categoryOptions", productService.getCategoryOptions());
        Product product = productService.getProductById(productId);

        @SuppressWarnings("unchecked")
        List<Product> products = (List<Product>) request.getSession().getAttribute("SHOPPING_CART");
        if (products == null) {
            products = new ArrayList<>();
            request.getSession().setAttribute("SHOPPING_CART", products);
        }
        products.add(product);
        model.addAttribute("shoppingCartList", products);
        request.getSession().setAttribute("SHOPPING_CART", products);

        return "redirect:/shop/";
    }
}
