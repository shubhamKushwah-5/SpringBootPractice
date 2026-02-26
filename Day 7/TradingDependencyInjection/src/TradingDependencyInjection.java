// Trading broker interface
interface Broker {
    void connect();
    void placeTrade(String symbol, int quantity, double price);
    double getBrokerageFee(double tradeValue);
}

//Different broker implementations
class ZerodhaBroker implements Broker {

    public void connect() {
        System.out.println("Connected to Zerodha Kite API");
    }

    public void placeTrade(String symbol, int quantity , double price) {
        double value = quantity * price;
        System.out.println("Zerodha: Placed trade for " + symbol);
        System.out.println("Quantity: " + quantity + ", Price: ₹" + price);
        System.out.println("Trade value: ₹" + value);
    }

    public double getBrokerageFee(double tradeValue) {
        return Math.min(20, tradeValue * 0.0003); // ₹20 or 0.03%, whichever is lower
    }
}

class UpstoxBroker implements Broker {
    public void connect(){
        System.out.println("Connected to upstox API");
    }

    public void placeTrade(String symbol, int quantity, double price) {
        double value = quantity * price;
        System.out.println("Upstox: Placed trade for " + symbol);
        System.out.println("Quantity: " + quantity + ", Price: ₹" + price);
        System.out.println("Trade value: ₹" + value);
    }

    public double getBrokerageFee(double tradeValue){
        return Math.min(20, tradeValue * 0.0005); //₹20 or 0.05%, whichever is lower
    }
}

class AngelOneBroker implements Broker {
    public void connect(){
        System.out.println("Connected to Angel One API");
    }

    public void placeTrade(String symbol, int quantity, double price ) {
        double value = quantity * price;
        System.out.println("Angel One: Placed trade for " + symbol);
        System.out.println("Quantity: " + quantity + ", Price: ₹" + price);
        System.out.println("Trade value: ₹" + value);
    }

    public double getBrokerageFee(double tradeValue) {
        return 0; // Zero brokerage
    }
}

//Trading System with Dependency Injection
class TradingSystem {
    private Broker broker; //Dependency
    private String traderName;

    // Constructor Injection
    public TradingSystem(String traderName, Broker broker) {
        this.traderName = traderName;
        this.broker = broker;
        System.out.println("Trading system initialized for " + traderName);
    }

    public void executeTrade(String symbol, int quantity, double price) {
        System.out.println("\n ===" + traderName + "executing trade ===");
        broker.connect();
        broker.placeTrade(symbol,quantity,price);

        double tradeValue = quantity * price;
        double brokerage = broker.getBrokerageFee(tradeValue);
        double netValue = tradeValue + brokerage;

        System.out.println("Brokerage: ₹" + brokerage);
        System.out.println("Net amount: ₹" + netValue);
    }
}

public class TradingDependencyInjection {
    public static void main(String[] args) {
        System.out.println("=== TRADING SYSTEM WITH DEPENDENCY INJECTION ===\n");

        //create different brokers
        Broker zerodha = new ZerodhaBroker();
        Broker upstox = new UpstoxBroker();
        Broker angelOne = new AngelOneBroker();

        //Trader 1 uses Zerodha
        TradingSystem trader1 = new TradingSystem("Rahul", zerodha);
        trader1.executeTrade("RELIANCE", 10, 2500);

        //Trader 2 uses upstox
        TradingSystem trader2 = new TradingSystem("Priya", upstox);
        trader2.executeTrade("TCS", 5, 3500);

        //Trader 3 uses Angel One (Zero Brokerage)
        TradingSystem trader3 = new TradingSystem("Amit", angelOne);
        trader3.executeTrade("INFY", 20,1500);
        System.out.println("\n=== KEY LEARNING ===");
        System.out.println("TradingSystem doesn't care which broker you use");
        System.out.println("We can easily switch brokers without changing TradingSystem code");
        System.out.println("This is EXACTLY what your Trading Journal API will use!");
    }
}
