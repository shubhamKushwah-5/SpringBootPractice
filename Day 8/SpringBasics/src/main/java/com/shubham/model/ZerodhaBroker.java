package com.shubham.model;

public class ZerodhaBroker implements Broker {

    public void placeTrade(String symbol, double price, int quantity) {
        System.out.println("Zerodha: Placing trade for " + symbol);
        System.out.println("Price: ₹" + price + ", Quantity: " + quantity);
        System.out.println("Total: ₹" + (price * quantity));
    }
}
