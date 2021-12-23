package com.example.productmicroservice.service;

import com.example.productmicroservice.ProductRepository;
import com.example.productmicroservice.config.ProductConfiguration;
import com.example.productmicroservice.dto.Product;
import com.example.productmicroservice.exception.CurrencyNotValidException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductConfiguration productConfiguration;
    List<Product> products=new ArrayList<>();


    public String addProduct(Product product) {
        log.info("Adding product");
        if(productConfiguration.getCurrencies().contains(product.getCurrency().toUpperCase()))
        {
            throw new CurrencyNotValidException("invalid currency");
        }
        productRepository.save(product);
      //products.add(product);
        return "success";
    }

    public List<Product> listAllProducts() {
        return productRepository.findAll();
        //return products;
    }

    public List<Product> productCategoryList(String category) {

        return productRepository.findByCategory(category);
        /*return products.stream().
                filter(product -> product.getCategory().getName().equalsIgnoreCase(category))
                .collect(Collectors.toList());*/
    }

    public Product productById(Integer id) {
        return productRepository.findById(id).get();
        /*return products.stream().
                filter(product -> product.getId()==id).findAny().get();*/
    }


    public String updateProduct(Product product) {
        productRepository.save(product);
      /*  for(Product prod:products)
        {
            if(prod.getId().equals(product.getId()))
            {

                prod.setName(product.getName());
                prod.setCategory(product.getCategory());
                prod.setDiscount(product.getDiscount());
                return "product updated successfully";
            }
        }
        return "product updation failed";*/
        return "product updated successfully";
    }

    public String deleteProductById(Integer id) {
        productRepository.deleteById(id);
       /* for(Product product:products)
        {
            if(product.getId()==id)
                products.remove(product);
            return "product deleted";

        }*/
        return "product deleted";
    }
}
