package com.example.productmicroservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "product")
    public class Product {

        @Id
        private String id;
        private String name;
        private Category category;
        private double price;
        private String currency;
        private double discount;
        private String discountDescription;
        private List<String> imageURLs;
    }

