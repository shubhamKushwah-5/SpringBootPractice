package com.shubham.model;

public class Trader {
    private String name;
    private Broker broker; // Dependency

    // Spring needs default constructor
    public Trader(){

    }

    public Trader(String name){
        this.name = name;
    }

    // Setter for dependency injection
    public void setBroker(Broker broker) {
        this.broker = broker;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void executeTrade(String symbol, double price, int quantity) {
        System.out.println(name + " is executing trade ");
        broker.placeTrade(symbol, price, quantity);
    }
}
