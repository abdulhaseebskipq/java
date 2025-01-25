package com.telusko.ecomApp.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private String category;
    private Date releaseDate;
    private boolean productAvailable;
    private int stockQuantity;
    private String imageName;
    private String imageType;

    public Product(int id, String name, String description, BigDecimal price, String category, Date releaseDate,
    boolean productAvailable, int stockQuantity, String imageName, String imageType, byte[] image, String brand) {
this.id = id;
this.name = name;
this.description = description;
this.price = price;
this.category = category;
this.releaseDate = releaseDate;
this.productAvailable = productAvailable;
this.stockQuantity = stockQuantity;
this.imageName = imageName;
this.imageType = imageType;
this.image = image;
this.brand = brand;
}
    public String getImageName() {
        return imageName;
    }
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    public String getImageType() {
        return imageType;
    }
    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }
    @Lob
    private byte[] image;

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", category=" + category
                + ", releaseDate=" + releaseDate + ", productAvailable=" + productAvailable + ", stockQuantity=" + stockQuantity
                + ", imageName=" + imageName + ", imageType=" + imageType + ", image=" + Arrays.toString(image)
                + ", brand=" + brand + "]";
    }
    private String brand;
    public Product() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getdescription() {
        return description;
    }
    public void setdescription(String description) {
        this.description = description;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    public boolean isproductAvailable() {
        return productAvailable;
    }
    public void setproductAvailable(boolean productAvailable) {
        this.productAvailable = productAvailable;
    }
    public int getstockQuantity() {
        return stockQuantity;
    }
    public void setstockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    

    
}
