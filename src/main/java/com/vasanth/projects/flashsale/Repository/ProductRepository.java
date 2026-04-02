package com.vasanth.projects.flashsale.Repository;

import com.vasanth.projects.flashsale.Entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
