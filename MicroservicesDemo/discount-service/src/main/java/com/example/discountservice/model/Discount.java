package com.example.discountservice.model;

public class Discount {
    private String brand;
    private String model;
    private Double discountPercentage;

    public Discount(String brand, String model, Double discountPercentage) {
        this.brand = brand;
        this.model = model;
        this.discountPercentage = discountPercentage;
    }

    // Getters and Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}