package com.example.productservice.service;

import com.example.productservice.model.Product;
import com.example.productservice.model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;

    public Product getProductDetails(String id) {
        // Dummy product data for demonstration
        Product product = new Product(id, "Apple", "iPhone 13", 999.0);

        // Fetch discount details from DiscountService
        String discountServiceUrl = "http://discount-service/discounts";
        Discount brandDiscount = restTemplate.getForObject(discountServiceUrl + "/brand/" + product.getBrand(), Discount.class);
        Discount modelDiscount = restTemplate.getForObject(discountServiceUrl + "/model/" + product.getModel(), Discount.class);

        // Apply the highest discount
        if (brandDiscount != null && modelDiscount != null) {
            product.setDiscountPercentage(Math.max(brandDiscount.getDiscountPercentage(), modelDiscount.getDiscountPercentage()));
        } else if (brandDiscount != null) {
            product.setDiscountPercentage(brandDiscount.getDiscountPercentage());
        } else if (modelDiscount != null) {
            product.setDiscountPercentage(modelDiscount.getDiscountPercentage());
        }

        return product;
    }

    public Product getProductDetailsFallback(String id) {
        // Fallback logic when DiscountService is unavailable
        Product product = new Product(id, "Apple", "iPhone 13", 999.0);
        product.setDiscountPercentage(0.0); // No discount
        return product;
    }
}