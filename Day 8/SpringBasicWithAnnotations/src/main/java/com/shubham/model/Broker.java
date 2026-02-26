package com.shubham.model;

public interface Broker {
    void placeTrade(String symbol, double price, int quantity);
}
