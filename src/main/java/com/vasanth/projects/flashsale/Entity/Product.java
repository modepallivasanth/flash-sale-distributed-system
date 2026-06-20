package com.vasanth.projects.flashsale.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    public Product(Long productId, String productName, Long productPrice, Long inventoryCount) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.inventoryCount = inventoryCount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private Long productPrice;
    private Long inventoryCount;

    public Product() {

    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public Long getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(Long inventoryCount) {
        this.inventoryCount = inventoryCount;
    }
}
