package com.shubham.student_api_challenge.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name= "studentData")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    @NotBlank(message =  "name cannot be empty")
    private String name;

    @Column(name = "Age")
    @Positive(message = "age can only be positive")
    int age ;

    @Column(name = "Course")
    @NotBlank(message = "cant be empty")
    private String course;

    @Column(name = "Standard")
    //@NotBlank(message = "cant be empty")//can only used on string
    private int standard;

    //constructor
    public Student(){
    }

    public Student(int id,String name,int age,String course,int standard){
        this.id = id;
        this.name = name;
        this.course = course;
        this.standard = standard;
    }

    //Getter and Setters
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getCourse(){
        return course;
    }

    public void setCourse(String course){
        this.course = course;
    }

    public int getStandard(){
        return standard;
    }

    public void setStandard(int standard){
        this.standard= standard;
    }

}
