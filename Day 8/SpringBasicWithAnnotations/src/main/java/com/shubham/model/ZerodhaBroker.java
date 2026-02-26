package com.shubham.model;

import org.springframework.stereotype.Component;

@Component // This tells Spring: "I'm a bean, create me!"
public class ZerodhaBroker implements Broker {

    public ZerodhaBroker() {
        System.out.println("ZerodhaBroker bean created by Spring");
    }

    public void placeTrade(String symbol, double price, int quantity) {
        System.out.println("Zerodha: Placing trade for " + symbol);
        System.out.println("Price: ₹" + price + ", Quantity: " + quantity);
        System.out.println("Total: ₹" + (price * quantity));
    }
}
