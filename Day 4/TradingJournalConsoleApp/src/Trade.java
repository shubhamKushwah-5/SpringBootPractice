public class Trade {
    //instance variables
    private String symbol ; // e.g. "reliance" or something
    private String type; // BUY OR SELL
    private double entryPrice;
    private double exitPrice;
    private int quantity;
    private String strategy ;
    private String notes ; //notes about the trade

    //getters
    public String getSymbol() {
        return symbol;
    }
    public String getType() {
        return type;
    }
    public double getEntryPrice() {
        return entryPrice;
    }
    public double getExitPrice() {
        return exitPrice;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getStrategy() {
        return strategy;
    }
    public String getNotes() {
        return notes;
    }

    //setter
    public void setNotes(String notes) {
        this.notes = notes;
    }

    // Constructor
    public Trade(String symbol, String type, double entryPrice, double exitPrice, int quantity, String strategy) {
        this.symbol = symbol;
        this.type = type;
        this.entryPrice = entryPrice;
        this.exitPrice = exitPrice;
        this.quantity = quantity;
        this.strategy = strategy;
        this.notes = "";
    }

    //method to calculate pnl automatically
    public double calculatePnL(){
        String tradeType = type.toUpperCase();
        double pnl = 0;

        if(tradeType.equals("BUY")){
            pnl = ((exitPrice - entryPrice) * (quantity));
        }
        if(tradeType.equals("SELL")){
            pnl = ((entryPrice - exitPrice) * (quantity));

        }
    return pnl;
    }

    // Method to know is this trade profitable ?
    public boolean isWinningTrade() {
       return calculatePnL() > 0;
    }

    //method to display all the trades
    public void displayTrade(){
        System.out.println("=== TRADE DETAILS ===");
        System.out.println("Symbol: " + symbol);
        System.out.println("Type: " + type);
        System.out.println("Entry: ₹" + entryPrice);
        System.out.println("Exit: ₹" + exitPrice);
        System.out.println("Quantity: " + quantity);
        System.out.println("Strategy: " + strategy);
        System.out.printf("P&L: ₹%.2f%n", calculatePnL());
        System.out.println("Result: " + (isWinningTrade() ? "WIN ✓" : "LOSS ✗"));

    }

}
