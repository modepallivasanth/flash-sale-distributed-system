package com.vasanth.projects.flashsale;

import com.vasanth.projects.flashsale.Entity.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.vasanth.projects.flashsale.Repository.ProductRepository;

@SpringBootApplication
public class FlashSaleEngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlashSaleEngineApplication.class, args);

    }

    @Bean
    public CommandLineRunner initData(ProductRepository repository) {
        return args -> {
            repository.deleteAll();
            Product product = new Product();
            product.setProductId(1L);
            product.setProductName("Limited Edition Sneaker");
            product.setInventoryCount(50L);
            repository.save(product);
            System.out.println("Test Product inserted with 50 inventory.");
        };
    }
}

