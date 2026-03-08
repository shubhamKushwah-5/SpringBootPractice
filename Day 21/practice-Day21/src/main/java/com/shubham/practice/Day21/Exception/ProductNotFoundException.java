package com.shubham.practice.Day21.Exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(){
        super("product not found with given details ");
    }
}
