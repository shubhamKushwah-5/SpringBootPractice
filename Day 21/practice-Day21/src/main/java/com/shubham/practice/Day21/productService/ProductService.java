package com.shubham.practice.Day21.productService;

import com.shubham.practice.Day21.Exception.ProductNotFoundException;
import com.shubham.practice.Day21.model.Product;
import com.shubham.practice.Day21.productRepository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    //get all product
    public List<Product> getAllProduct(){
        return productRepo.findAll();
    }

    //get product by id
    public Product getProductById(Long id){
        Product product =  productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException());
        return product;
    }

    //add product
    public Product addProduct(Product product){
        return productRepo.save(product);
    }

    //update product
    public Product updateProduct(Long id, Product details){
        Product product = getProductById(id);
        product.setCategory(details.getCategory());
        product.setName(details.getName());
        product.setPrice(details.getPrice());
        product.setStock(details.getStock());
        return productRepo.save(product);

    }

    //delete product
    public void deleteProduct(Long id){
        productRepo.deleteById(id);

    }

    //get product by category
    public List<Product> getProductsByCategory(String category){
        List<Product> categoryProduct = productRepo.findAll();
//        return categoryProduct.stream()
//                .filter(t -> t.getCategory().equalsIgnoreCase(category))
//                .collect(Collectors.toList());
        return productRepo.findByCategory(category);

    }
}



