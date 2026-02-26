package com.shubham.myApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //spring will create obj for this class bocz of this component annotation
public class Dev {

    @Autowired// field injection
    private Computer comp ;  //laptop is instance variable and by default the get value null

//    public Dev(Laptop laptop){ //constructor injection
//        this.laptop= laptop;
//    }

//    @Autowired //setter injection
//    public void setLaptop(Laptop laptop){
//        this.laptop = laptop;
//    }

    public void build(){

        comp.compile();

        System.out.println("working on Awesome Project");

    }

}
