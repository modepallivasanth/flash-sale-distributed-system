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
        java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("Asia/Kolkata"));
        SpringApplication.run(FlashSaleEngineApplication.class, args);

    }

    @Bean
    public CommandLineRunner initData(ProductRepository repository) {
        return args -> {
            repository.deleteAll();
            Product product = new Product();
            product.setProductName("Limited Edition Sneaker");
            product.setInventoryCount(50L);
            repository.save(product);
            System.out.println("=================================================");
            System.out.println("Test Product inserted with ID: " + product.getProductId());
            System.out.println("=================================================");
        };
    }
}

