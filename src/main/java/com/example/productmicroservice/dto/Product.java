package com.example.productmicroservice.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
        @NotNull(message="Product name should not be null")
        private String name;

        @NotNull(message="Category should not be null")
        private Category category;
        @Min(0)
        private double price;
        @Max(100)
        private String currency;
        private double discount;
        private String discountDescription;
        private List<String> imageURLs;
    }

