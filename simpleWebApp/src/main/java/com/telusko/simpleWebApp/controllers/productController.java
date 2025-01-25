package com.telusko.simpleWebApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.simpleWebApp.models.Product;
import com.telusko.simpleWebApp.services.productService;

@RestController
public class productController {
    @Autowired
    productService service;

    @RequestMapping("/products")
    public List<Product> listProducts() {
        return service.getProducts();
    }

    @RequestMapping("/products/{prodId}")
    public Product getProdyProductsById(@PathVariable int prodId) {
        return service.getProductByById(prodId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product p) {
        service.addProduct(p);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product p) {
        service.updateProduct(p);
    }

    @DeleteMapping("/products/{prodId}")
    public void updateProduct(@PathVariable int prodId) {
        service.deleteById(prodId);
    }
}
