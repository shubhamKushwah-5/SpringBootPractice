package com.shubham.practice.Day21.productService;

import com.shubham.practice.Day21.model.Product;
import com.shubham.practice.Day21.productRepository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public ResponseEntity<Product> getAllProduct(){
        return productRepo.findAll();
    }

    public ResponseEntity<Product> getProductById(){
        return productRepo.findAll();
    }

    public ResponseEntity<Product> addProduct(Product product){
        productRepo.save(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    public ResponseEntity<Product> updateProduct(Long id, Product details){
        Optional<Product> oldProd = productRepo.findById(id);
        productRepo.save(details);

    }

    public ResponseEntity<?> deleteProduct(Long id){
        productRepo.deleteById(id);
        return new ResponseEntity<>("product with " + id " deleted",HttpStatus.OK );

    }

    public ResponseEntity<Product> getProductsByCategory(String category){
        productRepo.findByCategory(category);

    }
}
