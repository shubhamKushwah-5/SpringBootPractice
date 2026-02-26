package com.shubham;

import com.shubham.config.AppConfig;
import com.shubham.model.Trade;
import com.shubham.model.Trader;
import com.shubham.service.TradeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        System.out.println("TRADING JOURNAL WITH SPRING \n");

        // Load Spring configuration (annotation-based) ie. Initialize Spring
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Get TradeService bean (Spring created it and injected repository
        TradeService tradeService = context.getBean(TradeService.class);
        System.out.println("  ADDING TRADES ");

        // Add some trades
        tradeService.addTrade(new Trade("RELIANCE", "BUY", 2500, 2550, 10, "Intraday"));
        tradeService.addTrade(new Trade("TCS", "BUY", 3500, 3450, 5, "Swing"));
        tradeService.addTrade(new Trade("INFY", "BUY", 1500, 1550, 20, "Scalping"));
        tradeService.addTrade(new Trade("HDFC", "SELL", 1600, 1550, 10, "Intraday"));
        tradeService.addTrade(new Trade("WIPRO", "BUY", 400, 420, 50, "Swing"));

        System.out.println(" ALL TRADES");
        for (Trade trade : tradeService.getAllTrades()) {
            System.out.printf("%s %s: Entry ₹%.2f, Exit ₹%.2f, P&L: ₹%.2f %s%n",
                    trade.getSymbol(), trade.getType(), trade.getEntryPrice(),
                    trade.getExitPrice(), trade.calculatePnL(),
                    trade.isWinningTrade() ? "✓" : "✗");
        }

        System.out.println(" Intraday Trades Only");
        for (Trade  trade : tradeService.getTradesByStrategy("Intraday")){
            System.out.printf("%s: P&L ₹%.2f%n",
                    trade.getSymbol(), trade.calculatePnL());
        }

        tradeService.displayStats();




        // Get bean
        //Trader trader = context.getBean(Trader.class);

        // Use it
        //trader.executeTrade("TCS", 3500, 5);

//        System.out.println("\n=== NO XML NEEDED! ===");
//        System.out.println("@Component tells Spring to create beans");
//        System.out.println("@Autowired tells Spring to inject dependencies");
//        System.out.println("Much cleaner than XML!");
    }
}