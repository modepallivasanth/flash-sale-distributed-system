package com.vasanth.projects.flashsale.Service;

import com.vasanth.projects.flashsale.Entity.Product;
import com.vasanth.projects.flashsale.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
    private ProductRepository productRepository;

//    private Product product;

    public String PurchaseProduct(Long id){

        Product product = productRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Product Not Found"));

        if (product.getInventoryCount()  > 0){

            product.setInventoryCount(product.getInventoryCount() - 1);
            productRepository.save(product);
            return "Purchased Successfully";
        }
        else{
            return "Product Out of Stock";
        }

    }
}
