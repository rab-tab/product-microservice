package com.example.productmicroservice.controller;

import com.example.productmicroservice.dto.Product;
import com.example.productmicroservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    ResponseEntity<Product> addProduct(@RequestBody Product product)
    {
        String status=productService.addProduct(product);
        log.info("Product added status - {} ",status);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/productList")
    public List<Product> listAllProducts()
    {
       return productService.listAllProducts();
    }

    @GetMapping("/productList/{category}")
    List<Product> productCategoryList(@PathVariable String category) {
        return productService.productCategoryList(category);
    }

    @GetMapping("/product/{id}")
    Product productById(@PathVariable Integer id) {
        return productService.productById(id);
    }

    @PutMapping("/productUpdate")
    String updateProduct(@RequestBody Product product) {

        return productService.updateProduct(product);
    }

    @DeleteMapping("/product/{id}")
    String deleteProductById(@PathVariable Integer id) {
        return productService.deleteProductById(id);
    }
}
