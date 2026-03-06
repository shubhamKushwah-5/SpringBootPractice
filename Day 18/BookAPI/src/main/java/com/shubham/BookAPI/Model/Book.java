package com.shubham.BookAPI.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @Positive
    private double price;

    //getter and setter
    public Long getId(){return id;}
    public void setId(Long id ){this.id = id;}

    public String gettitle(){return title;}
    public void setTitle(String title){this.title = title;}

    public String getauthor(){return author;}
    public void setAuthor(String author){this.author = author;}

    public double getPrice(){return price;}
    public void setPrice(double price){this.price = price;}

    //constructor
    public Book(){
    }

    public Book(Long id, String title, String author, double price){
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }


}
