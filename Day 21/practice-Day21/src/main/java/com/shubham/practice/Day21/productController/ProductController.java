package com.shubham.practice.Day21.productController;

import com.shubham.practice.Day21.model.Product;
import com.shubham.practice.Day21.productService.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Value("${file.upload-dir}")
    private String uploadDir;



    @GetMapping()
    public List<Product> allProducts(){
        return productService.getAllProduct();
    }

    //Get all product pagination
    @GetMapping("/paginated")
    public Page<Product> getProductsPaginated(
            @RequestParam (defaultValue = "5") int size,
            @RequestParam (defaultValue = "0" ) int page,
            @RequestParam (defaultValue = "name") String sortBy,
            @RequestParam (defaultValue = "asc") String direction) {

                return productService.getAllProductPaginated(page,size,sortBy,direction);
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

    //add product with image(multipart)
    @PostMapping(value = "/with-image", consumes = "multipart/form-data")
    public ResponseEntity<Product> addProductWithImage(
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam("category") String category,
            @RequestParam("stock") int stock,
            @RequestParam(value = "image", required = false)MultipartFile image) throws IOException{

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);
        product.setStock(stock);

        Product saved = productService.addProductWithImage(product,image);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);

    }

    //upload image to existing product
    @PostMapping("/{id}/image")
    public Product uploadImage(
            @PathVariable Long id,
            @RequestParam("image") MultipartFile image) throws IOException {

        return productService.updateProductImage(id,image);
    }


    //Get product image
    @GetMapping("/{id}/imagae")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws IOException {
        Product product = productService.getProductById(id);

        if(product.getImageUrl() == null) {
            return ResponseEntity.notFound().build();
        }

        Path filePath = Paths.get(uploadDir).resolve(product.getImageUrl());
        byte[] image = Files.readAllBytes(filePath);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image);
    }



}
