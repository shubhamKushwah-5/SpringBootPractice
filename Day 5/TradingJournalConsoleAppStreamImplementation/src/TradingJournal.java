import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class TradingJournal {
    private ArrayList<Trade> trades = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);


    //method to add trade
    public void addTrade(){
        System.out.print("Symbol (e.g. RELIANCE): ");
        String symbol = scanner.nextLine().toUpperCase();

        System.out.print("Type (BUY/SELL): ");
        String type = scanner.nextLine().toUpperCase();

        System.out.print("Entry Price: ");
        double entry = scanner.nextDouble();

        System.out.print("Exit Price: ");
        double exit = scanner.nextDouble();

        System.out.print("Quantity: ");
        int qty = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Strategy (Scalping/Swing/Intraday): ");
        String strategy = scanner.nextLine();

        Trade trade1 = new Trade(symbol,type,entry,exit,qty,strategy);

        System.out.println("Notes (optional, press Enter to skip):");
        String notes = scanner.nextLine();
        trade1.setNotes(notes);


        //add to the arraylist
        trades.add(trade1);
        System.out.println("Trade added!");
        trade1.displayTrade();
    }

    //method to viewalltrades
    public void displayTrade(){
        if(trades.isEmpty()){
            System.out.println("No trades yet.");
        }
        for(Trade t: trades){
            t.displayTrade();
        }
    }

    //to view stats about all trades
    public void viewStats(){
        if(trades.isEmpty()) {
            System.out.println("No trades yet.");
            return;
        }

        double totalPnl = 0;
        int numberOfWinningTrades = 0;
        int numberOfLosingTrades = 0;

        for(Trade t : trades){
            totalPnl = totalPnl + t.calculatePnL();
            if(t.isWinningTrade())
                numberOfWinningTrades ++;
            else
                numberOfLosingTrades ++;
        }


        //Total number of trades
       // int totalNumberOfTrades = trades.size();

//        //Number of winning trades
//        int numberOfWinningTrades = 0;
//        for(Trade t: trades){
//            if(t.isWinningTrade()){
//                numberOfWinningTrades++;
//            }
//        }
//        //Number of losing trades
//        int numberOfLosingTrades = 0;
//        for(Trade t: trades){
//            if( !t.isWinningTrade()){
//                numberOfLosingTrades ++;
//            }
//        }

        //win rate;
        double winRate = (numberOfWinningTrades * 100) / trades.size() ;

//        try {
//            winRate = (numberOfWinningTrades / numberOfLosingTrades ) * 100;
//        } catch (Exception e){
//            System.out.println("cannot divide by zero");
//        }

//        //total pnl across all trades
//        double totalPnl = 0;
//        for(Trade t : trades ){
//            totalPnl += t.calculatePnL();
//        }

        //overall status

        //String overallStatus = (totalPnl > 0) ? "Profitable" : "Losing" ;


        System.out.println("\n=== YOUR STATS ===");
        System.out.println("Total Trades: " + trades.size());
        System.out.println("Wins: " + numberOfWinningTrades);
        System.out.println("Losses: " + numberOfLosingTrades);
        System.out.printf("Win Rate: %.1f%%%n", winRate);
        System.out.printf("Total P&L: ₹%.2f%n", totalPnl);
        System.out.println(totalPnl > 0 ? "Overall: PROFITABLE ✓" : "Overall: LOSING ✗");
    }

    public void showMenu(){
        System.out.println("====== Trading Journal (Console Version) ======");
        while(true){
            System.out.println("\n1. Add Trade");
            System.out.println("2. View All Trade");
            System.out.println("3. View Stats");
            System.out.println("4. Filter by Strategy");
            System.out.println("5. show winning trades");
            System.out.println("6. Total P&L");
            System.out.println("7. Best Trade");
            System.out.println("8. Worst Trade");
            System.out.println("9. Exit");
            System.out.println("choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 :
                    addTrade();
                    break;
                case 2 :
                    displayTrade();
                    break;
                case 3 :
                    viewStats();
                    break;
                case 4 :
                    String sc = scanner.nextLine();
                    viewTradeByStrategy(sc);
                    break;
                case 5 :
                    viewWinningTrades();
                    break;
                case 6 :
                    System.out.println(getTotalPnL());
                    break;
                case 7 :
                    showBestTrade();
                    break;
                case 8 :
                    showWorstTrade();
                    break;
                case 9 :
                    return;

                default :
                    System.out.println("please enter valid choice ");
            }
        }



    }

    //methods using streams
    public void viewWinningTrades(){
        trades.stream()
                .filter(Trade::isWinningTrade)
                .forEach(Trade:: displayTrade);

    }

    //filter by strategy
    public void viewTradeByStrategy(String strategy){
        trades.stream()
                .filter(t -> t.getStrategy().equalsIgnoreCase(strategy))
                .forEach(Trade::displayTrade);

    }

    //Total pnl using stream
    public double getTotalPnL(){
        return trades.stream()                           //the conveyor belt
                     .mapToDouble(Trade:: calculatePnL) //the inspector
                     .sum();                             // the calculator
    }

    //Best trade
    public void showBestTrade(){
        trades.stream()
                .max((t1,t2) -> Double.compare(t1.calculatePnL(), t2.calculatePnL()))
                .ifPresent(t -> {
                    System.out.println("BEST TRADE:");
                    t.displayTrade();
                });
    }

    //Worst Trade
    public void showWorstTrade(){
        trades.stream()
                .min((t1,t2) -> Double.compare(t1.calculatePnL(),t2.calculatePnL()))
                .ifPresent(t -> {
                    System.out.println("WORST TRADE");
                    t.displayTrade();
                });
    }




}
