package com.telusko.simpleWebApp.models;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Entity
public class Product {

    @Id
    private int id;
    private int price;
    private String name;

    public int getId() {
        return id;
    }

    public Product() {
    }

    public Product(int id, int price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", price=" + price + ", name=" + name + "]";
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
