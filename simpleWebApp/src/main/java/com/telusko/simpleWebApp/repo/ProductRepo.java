package com.telusko.simpleWebApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.simpleWebApp.models.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
