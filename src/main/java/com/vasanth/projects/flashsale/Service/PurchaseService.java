package com.vasanth.projects.flashsale.Service;

import com.vasanth.projects.flashsale.Entity.Product;
import com.vasanth.projects.flashsale.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class PurchaseService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StringRedisTemplate redisTemplate;

    // Inject the Lua script we pre-loaded in memory via RedisConfig
    @Autowired
    private RedisScript<Long> stockScript;


    @Transactional
    public String purchaseProduct(Long id){

        String redisKey = "product:" + id + ":stock";

        Long result = redisTemplate.execute(stockScript, Collections.singletonList(redisKey));
        Product product = productRepository.findByIdForUpdate(id).
                orElseThrow(() -> new RuntimeException("Product Not Found"));

        if (result != null && result == 1L) {
            // Notice we are NOT touching PostgreSQL here. Redis is the sole gatekeeper.
            return "Purchased Successfully. Approved by Redis Gatekeeper.";
        } else {
            return "Product Out of Stock. Rejected by Redis.";
        }
    }
}