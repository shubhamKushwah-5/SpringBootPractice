package com.shubham.service;


import com.shubham.model.Trade;
import com.shubham.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //spring will create this as a bean
public class TradeService {

    @Autowired // spring will inject TradeRepository automatically
    private TradeRepository repository;

    public TradeService(){
        System.out.println("TradeService been created");
    }

    public Trade addTrade(Trade trade) {
        return repository.save(trade);
    }

    public List<Trade> getAllTrades(){
        return repository.findAll();
    }

    public List<Trade> getTradesByStrategy(String strategy) {
        return repository.findByStrategy(strategy);
    }

    public double getTotalPnL(){
        double total = 0;
        for (Trade trade: repository.findAll()){
            total += trade.calculatePnL();
        }
        return total;
    }

    public double getWinRate() {
        List<Trade> allTrades = repository.findAll();
        if (allTrades.isEmpty() )
            return  0;

        int wins = 0;
        for (Trade trade : allTrades) {
            if(trade.isWinningTrade() ) wins ++;
        }
        return (wins * 100.0) / allTrades.size();
    }

    public void displayStats() {
        System.out.println("\n=== TRADING STATS ===");
        System.out.println("Total Trades: " + repository.count());
        System.out.printf("Total P&L: ₹%.2f%n", getTotalPnL());
        System.out.printf("Win Rate: %.1f%%%n", getWinRate());
    }
}
