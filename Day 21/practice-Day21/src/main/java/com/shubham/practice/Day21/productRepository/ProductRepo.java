package com.shubham.practice.Day21.productRepository;

import com.shubham.practice.Day21.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Long> {

  List<Product> findByCategory(String category);
}
