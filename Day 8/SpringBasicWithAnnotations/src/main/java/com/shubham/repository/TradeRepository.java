package com.shubham.repository;

import com.shubham.model.Trade;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository //spring will create this as a bean
public class TradeRepository {
    private List<Trade> trades = new ArrayList<>();
    private Long nextId = 1L;

    public TradeRepository(){
        System.out.println("TradeRepository bean created");
    }

    public Trade save(Trade trade){
        trades.add(trade);
        System.out.println("Trade saved: " + trade.getSymbol());
        return trade;
    }

    public List<Trade> findAll() {
        return new ArrayList<>(trades);
    }

    public List<Trade> findByStrategy(String strategy) {
        List<Trade> result = new ArrayList<>();
        for (Trade trade : trades) {
            if(trade.getStrategy().equalsIgnoreCase(strategy)) {
                result.add(trade);
            }
        }
        return result;
    }

    public int count(){
        return trades.size();
    }
}
