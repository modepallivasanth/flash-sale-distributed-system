package com.vasanth.projects.flashsale.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    public Product(Long productId, String productName, String productPrice, Long inventoryCount) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.inventoryCount = inventoryCount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String productPrice;
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

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public Long getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(Long inventoryCount) {
        this.inventoryCount = inventoryCount;
    }
}
