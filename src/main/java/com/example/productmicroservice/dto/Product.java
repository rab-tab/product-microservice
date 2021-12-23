package com.example.productmicroservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
    public class Product {

        private String id;
        private String name;
        private Category category;
        private double price;
        private String currency;
        private double discount;
        private String discountDescription;
        private List<String> imageURLs;
    }

