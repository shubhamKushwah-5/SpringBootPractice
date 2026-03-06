package com.shubham.journal_api.controller;

import com.shubham.journal_api.exception.TradeNotFoundException;
import com.shubham.journal_api.model.Trade;
import com.shubham.journal_api.repository.TradeRepository;
import com.shubham.journal_api.service.TradeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



@RestController
@RequestMapping("/api/trades") //base url for all endpoints
public class TradeController{

    // use tradeService not tradeRepo directly
//    @Autowired //spring will inject repository dependency
//    private TradeRepository tradeRepository;

    //temporary storage
   // private List<Trade> trades = new ArrayList<>();

    @Autowired
    private TradeService tradeService;

    //                 BASIC CRUD CONTROLLERS
    //Get all trades
    @GetMapping
    public List<Trade> getAllTrades(@RequestParam String username){
        return tradeService.getUserTrades(username);
    }

    // GET single trade by ID
    @GetMapping("/{id}")
    public Trade getTradeById(@PathVariable  Long id,@RequestParam String username) {
        return tradeService.getTradeById(id,username);
    }

    //add new trade
    @PostMapping
    public ResponseEntity<Trade> addNewTrade(@Valid @RequestBody Trade trade,@RequestParam String username){
        Trade savedTrade = tradeService.addTrade(trade,username);
        return new ResponseEntity<>(savedTrade, HttpStatus.CREATED);  //201 status will be there


    }

    //counting trades number
//    @GetMapping("/count")
//    public String getTradeCount(){
//        return "Total trades: " + trade.size();
//
//    }
//
//    //trade pnl
//    @GetMapping("/{index}/pnl")
//    public String getTradePnL(@PathVariable int index){
//        if(index >= 0 && index < trade.size()) {
//            Trade trade = trade.get(index);
//            double pnl = trade.calculatePnL();
//            return String.format("P&L for %s: ₹%.2f %s",
//                    trade.getSymbol(), pnl, pnl > 0 ? "✓" : "✗");
//        }
//        return "Trade not found" ;
//    }



    //put - update trade
    @PutMapping("/{id}")
    public Trade updateTrade(@PathVariable Long id,
                             @Valid @RequestBody Trade tradeDetails,
                             @RequestParam String username){
        return tradeService.updateTrade(id,tradeDetails,username);

    }

    //Delete trade
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrade(@PathVariable Long id, @RequestParam String username){
        tradeService.deleteTrade(id,username);
        return ResponseEntity.ok("Trade deleted with id: " + id);

    }

    //            STATISTICS ENDPOINTS

    //total pnl
    @GetMapping("/stats/total-pnl")
    public double getTotalPnL(@RequestParam String username) {
        return tradeService.getTotalPnL(username);
    }

    //winrate
    @GetMapping("/stats/winrate")
    public String getWinRate(@RequestParam String username){
        double winRate = tradeService.getWinRate(username);
        return String.format("Win rate: %.1f%%, ", winRate);
    }

    //GET best trade(highest pnl)
    @GetMapping("/stats/best-trade")
    public ResponseEntity<Trade> getBestTrade(@RequestParam String username){
        Trade best = tradeService.getBestTrade(username);
        if(best == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(best);
    }

    //GET worst trade(lowest pnl)
    @GetMapping("/stats/worst-trade")
    public ResponseEntity<Trade> getWorstTrade(@RequestParam String username){
       Trade worst = tradeService.getWorstTrade(username);
       if(worst == null){
           return ResponseEntity.noContent().build();
       }
       return ResponseEntity.ok(worst);
    }

    //GET average pnl per trade
    @GetMapping("/stats/avg-pnl")
    public double getAveragePnl(@RequestParam String username){
        return tradeService.getAveragePnl(username);
    }


    //GET statistics by Strategy
    @GetMapping("/stats/by-strategy")
    public List<Map<String,Object>> getStatsByStrategy(@RequestParam String username){
        return tradeService.getStatsbyStrategy(username);

    }

    //GET trades count by symbol
    @GetMapping("/stats/by-symbol")
    public List<Map<String,Object>> getTradesBySymbol(@RequestParam String username) {
        return tradeService.getCountBySymbol(username);

    }


    //GET win/loss breakdown
    @GetMapping("/stats/win-loss")
    public Map<String,Object> getWinLossBreakdown(@RequestParam String username){
        return tradeService.getWinLossBreakdown(username);
    }

    //    FILTERING ENDPOINTS


    //get trades by strategy
    @GetMapping("/strategy/{strategy}")
    public List<Trade> getTradesByStrategy(@PathVariable String strategy, @RequestParam String username) {
        return tradeService.getTradesByStrategy(username,strategy);
    }

    //  DATE BASED ENDPOINTS

    //GET trades form specific date
    @GetMapping("/date/{date}")
    public List<Trade> getTradesByDate(@PathVariable String date,@RequestParam String username){

        return tradeService.getTradesByDate(username,date);
    }

    //GET trades form date range
    @GetMapping("/date-range")
    public List<Trade> getTradesByDateRange(
            @RequestParam String start,
            @RequestParam String end,
            @RequestParam String username) {

        return tradeService.getTradesByDateRange(username,start,end);
    }

    //GET today's trades
    @GetMapping("/today")
    public List<Trade> getTodayTrades(@RequestParam String username){
        return tradeService.getTodayTrades(username);
    }

    //GET this week's trades
    @GetMapping("/this-week")
    public List<Trade> getThisWeekTrades(@RequestParam String username){
       return tradeService.getThisWeekTrades(username);
    }

    //GET this month's trades
    @GetMapping("/this-month")
    public List<Trade> getThisMonthTrades(@RequestParam String username) {
        return tradeService.getThisMonthTrades(username);
    }





}
