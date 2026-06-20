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
            // 1. Clear old data
            repository.deleteAll();

            // 2. Create and save the product (Postgres generates the ID)
            Product product = new Product();
            product.setProductName("Limited Edition Sneaker");
            product.setProductPrice(199L);
            product.setInventoryCount(50L);
            // We must capture the saved instance to get the actual generated ID
            Product savedProduct = repository.save(product);
            Long actualId = savedProduct.getProductId();

            // 3. Dynamically inject the correct ID into the Redis key
            String dynamicRedisKey = "product:" + actualId + ":stock";
            redisTemplate.opsForValue().set(dynamicRedisKey, "5");

            System.out.println("=================================================");
            System.out.println("Test Product inserted with ID: " + actualId);
            System.out.println("Seeded Redis Key: '" + dynamicRedisKey + "' with 5 items.");
            System.out.println("=================================================");
        };
    }
}

