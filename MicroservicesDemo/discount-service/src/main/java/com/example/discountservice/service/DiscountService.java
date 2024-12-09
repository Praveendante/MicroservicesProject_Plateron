package com.example.discountservice.service;

import com.example.discountservice.model.Discount;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    public Discount getDiscountByBrand(String brand) {
        // Dummy data for demonstration
        return new Discount(brand, null, 10.0); // 10% discount on brand
    }

    public Discount getDiscountByModel(String model) {
        // Dummy data for demonstration
        return new Discount(null, model, 5.0); // 5% discount on model
    }
}