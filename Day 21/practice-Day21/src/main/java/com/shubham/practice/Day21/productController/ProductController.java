package com.shubham.practice.Day21.productController;

import com.shubham.practice.Day21.model.Product;
import com.shubham.practice.Day21.productService.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public List<Product> allProducts(){
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public Product productById(@Valid @PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping()
    public Product addProduct(@Valid @RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@Valid @PathVariable Long id, @RequestBody Product product){
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@Valid @PathVariable Long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/category/{category}")
    public void productByCategory(@PathVariable String category){
        productService.getProductsByCategory(category);
    }


}
