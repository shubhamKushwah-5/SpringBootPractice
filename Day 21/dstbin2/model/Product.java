package com.shubham.practice.Day21.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Positive
    private double price;

    @NotBlank
    private String category;

    @PositiveOrZero
    private int stock;

    //Getter and setters
    public Long getId(){return id;}
    public void setId(Long id){ this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}

    public int getStock() {return stock;}
    public void setStock(int stock) {this.stock = stock;}

    //Constructors
    //noargs constructor
    public Product(){};

    //all args constructor
    public Product(Long id, String name, double price, String category, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }
}
