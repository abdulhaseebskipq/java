package com.telusko.ecomApp.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.telusko.ecomApp.model.Product;
import com.telusko.ecomApp.repo.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;
    public List<Product> getAllProducts() {
        return repo.findAll();
    }
    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }
    public Product addProducts(Product p, MultipartFile imageFile) throws IOException {
        p.setImageName(imageFile.getName());
        p.setImageType(imageFile.getContentType());
        p.setImage(imageFile.getBytes());
        return repo.save(p); 

    }
    public Product updateProduct(Product p, MultipartFile imageFile, int id) throws IOException{
        p.setImage(imageFile.getBytes());
        p.setImageName(imageFile.getName());
        p.setImageType(imageFile.getContentType());
        return repo.save(p);
    }
    public void deleteProduct(int id) {
        repo.delete(getProductById(id));
    }
    public List<Product> searchProducts(String keyword) {
        return repo.searchKeyword(keyword);
    }
    
}
