package com.telusko.ecomApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.telusko.ecomApp.model.Product;
import com.telusko.ecomApp.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(service.getAllProducts(),HttpStatus.OK);
    } 

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product p = service.getProductById(id);
        if (p!=null)
            return new ResponseEntity<>(p,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProducts(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        try{
            Product product1 = service.addProducts(product,imageFile);
            return new ResponseEntity<>(product1,HttpStatus.OK);
        } 
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImageById(@PathVariable int id){

        Product product = service.getProductById(id);

        byte[] image = product.getImage();
        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).
        body(image);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@RequestPart Product product,@RequestPart MultipartFile imageFile, @PathVariable int id){
        try{
            Product product1 = service.updateProduct(product,imageFile,id);
            return new ResponseEntity<>(product1,HttpStatus.OK);
        } 
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id){
        try{
            service.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } 
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){
        List<Product>  products = service.searchProducts(keyword);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
    
}
