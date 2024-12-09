package com.example.productservice.controller;

import com.example.productservice.model.Product;
import com.example.productservice.service.ProductService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    @CircuitBreaker(name = "discountService", fallbackMethod = "getProductDetailsFallback")
    public Product getProductDetails(@PathVariable String id) {
        return productService.getProductDetails(id);
    }

    public Product getProductDetailsFallback(String id, Throwable throwable) {
        return productService.getProductDetailsFallback(id);
    }
}