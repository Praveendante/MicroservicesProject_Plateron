package com.example.discountservice.controller;

import com.example.discountservice.model.Discount;
import com.example.discountservice.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discounts")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @GetMapping("/brand/{brand}")
    public Discount getDiscountByBrand(@PathVariable String brand) {
        return discountService.getDiscountByBrand(brand);
    }

    @GetMapping("/model/{model}")
    public Discount getDiscountByModel(@PathVariable String model) {
        return discountService.getDiscountByModel(model);
    }
}