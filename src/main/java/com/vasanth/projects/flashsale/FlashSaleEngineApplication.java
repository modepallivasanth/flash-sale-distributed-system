package com.vasanth.projects.flashsale;

import com.vasanth.projects.flashsale.Entity.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.vasanth.projects.flashsale.Repository.ProductRepository;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
public class FlashSaleEngineApplication {

    public static void main(String[] args) {
        java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("Asia/Kolkata"));
        SpringApplication.run(FlashSaleEngineApplication.class, args);

    }

    @Bean
    public CommandLineRunner initData(ProductRepository repository, StringRedisTemplate redisTemplate) {
        return args -> {

            repository.deleteAll();
            Product product = new Product();
            product.setProductName("Limited Edition Sneaker");
            product.setProductPrice(199L);
            product.setInventoryCount(50L);
            repository.save(product);

            redisTemplate.opsForValue().set("product:1:stock", "50");
            System.out.println("=================================================");
            System.out.println("Test Product inserted with ID: " + product.getProductId());
            System.out.println("System Initialized: Postgres has 50 items. Redis has 50 items.");
            System.out.println("=================================================");
        };
    }
}

