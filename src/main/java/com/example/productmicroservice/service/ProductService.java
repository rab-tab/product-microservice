package com.example.productmicroservice.service;

import com.example.productmicroservice.dto.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    List<Product> products=new ArrayList<>();
    public String addProduct(Product product) {
        products.add(product);
        return "success";
    }

    public List<Product> listAllProducts() {
        return products;
    }

    public List<Product> productCategoryList(String category) {
        return products.stream().
                filter(product -> product.getCategory().getName().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public Product productById(String id) {
        return products.stream().
                filter(product -> product.getId()==id).findAny().get();
    }


    public String updateProduct(Product product) {
        for(Product prod:products)
        {
            if(prod.getId()==product.getId())
            {
                prod.setName(product.getName());
                prod.setCategory(product.getCategory());
                prod.setDiscount(product.getDiscount());
                return "product updated successfully";
            }
        }
        return "product updation failed";
    }

    public String deleteProductById(String id) {
        for(Product product:products)
        {
            if(product.getId()==id)
                products.remove(product);
            return "product deleted";

        }
        return "product deletion failure";
    }
}
