package com.telusko.simpleWebApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.simpleWebApp.models.Product;
import com.telusko.simpleWebApp.repo.ProductRepo;

@Service
public class productService {

    @Autowired
    ProductRepo repo;

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Product getProductByById(int prodId) {
        return repo.findById(prodId).orElse(new Product());
    }

    public void addProduct(Product p) {
        repo.save(p);
    }

    public void updateProduct(Product p) {
        repo.save(p);
    }

    public void deleteById(int pId) {
        repo.deleteById(pId);
    }

}
