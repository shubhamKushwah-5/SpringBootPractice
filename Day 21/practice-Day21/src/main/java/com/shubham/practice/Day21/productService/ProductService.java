package com.shubham.practice.Day21.productService;

import com.shubham.practice.Day21.Exception.ProductNotFoundException;
import com.shubham.practice.Day21.model.Product;
import com.shubham.practice.Day21.productRepository.ProductRepo;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private FileUploadService fileUploadService;

    //get all product
    public List<Product> getAllProduct(){
        return productRepo.findAll();
    }

    //get Product with pagination and sorting
    public Page<Product> getAllProductPaginated(int page,int size,String sortBy,String direction){
        Sort sort = direction.equalsIgnoreCase("asc")
                ?Sort.by(sortBy).ascending()
                :Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page,size,sort);

        return productRepo.findAll(pageable);
    }

    //get product by id
    public Product getProductById(Long id){
        Product product =  productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException());
        return product;
    }



    //add product
    public Product addProduct( Product product){
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
    //add product with image
    public Product addProductWithImage(Product product, MultipartFile image) throws IOException {
        //upload image if provided
        if (image != null && !image.isEmpty()){
            String filename = fileUploadService.uploadFile(image);
            product.setImageUrl(filename);
        }

        return productRepo.save(product);
    }

    public Product updateProductImage(Long id, MultipartFile image) throws IOException {
        Product product = getProductById(id);

        //delete old image if exist
        if(product.getImageUrl() != null) {
            fileUploadService.deleteFile(product.getImageUrl());
        }

        //upload new image
        String filename = fileUploadService.uploadFile(image);
        product.setImageUrl(filename);

        return productRepo.save(product);
    }
}



