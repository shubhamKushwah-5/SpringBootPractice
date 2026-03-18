package com.shubham.practice.Day21.productRepository;

import com.shubham.practice.Day21.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {

    public Product findByCategory(String category){
    }
}
