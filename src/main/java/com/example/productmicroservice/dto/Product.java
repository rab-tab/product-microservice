package com.example.productmicroservice.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
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

