package com.shubham.model;

public class Trade {
    private String symbol;
    private String type; //BUY OR SELL
    private double entryPrice;
    private double exitPrice;
    private int quantity;
    private String strategy;

    public Trade() {}

    public Trade(String symbol, String type, double entryPrice,
                 double exitPrice, int quantity, String strategy) {
        this.symbol = symbol;
        this.type = type;
        this.entryPrice = entryPrice;
        this.exitPrice = exitPrice;
        this.quantity = quantity;
        this.strategy = strategy;
    }
    public double calculatePnL() {
        if(type.equals("BUY")){
            return (exitPrice - entryPrice) * quantity;
        } else {
            return (entryPrice - exitPrice) * quantity;
        }
    }

    public boolean isWinningTrade() {
        return calculatePnL() > 0;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(double entryPrice) {
        this.entryPrice = entryPrice;
    }

    public double getExitPrice() {
        return exitPrice;
    }

    public void setExitPrice(double exitPrice) {
        this.exitPrice = exitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }
}
