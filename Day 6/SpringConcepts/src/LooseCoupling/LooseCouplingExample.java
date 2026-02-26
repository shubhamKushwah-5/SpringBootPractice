package LooseCoupling;


// Step 1: Create an interface (contract)
interface Database {
    void connect();
    void saveData(String data);
}

// Step 2: Different implementations of the interface
class MySQLDatabase implements Database {
    public void connect() {
        System.out.println("Connected to MySQL");
    }

    public void saveData(String data) {
        System.out.println("Saved to MySQL: " + data);
    }
}

class MongoDBDatabase implements Database {
    public void connect() {
        System.out.println("Connected to MongoDB");
    }

    public void saveData(String data) {
        System.out.println("Saved to MongoDB: " + data);
    }
}

class PostgreSQLDatabase implements Database {
    public void connect() {
        System.out.println("Connected to PostgreSQL");
    }

    public void saveData(String data) {
        System.out.println("Saved to PostgreSQL: " + data);
    }
}

// Step 3: UserService now depends on INTERFACE, not concrete class
class UserService {
    private Database database; // Loosely coupled!

    // Constructor injection - we "inject" the dependency
    public UserService(Database database) {
        this.database = database;
    }

    public void registerUser(String username) {
        database.connect();
        database.saveData(username);
        System.out.println("User registered: " + username);
    }
}

public class LooseCouplingExample {
    public static void main(String[] args) {
        // We can easily switch databases WITHOUT changing UserService!

        System.out.println("=== Using MySQL ===");
        Database mysql = new MySQLDatabase();
        UserService service1 = new UserService(mysql);
        service1.registerUser("Rahul");

        System.out.println("\n=== Using MongoDB ===");
        Database mongo = new MongoDBDatabase();
        UserService service2 = new UserService(mongo);
        service2.registerUser("Priya");

        System.out.println("\n=== Using PostgreSQL ===");
        Database postgres = new PostgreSQLDatabase();
        UserService service3 = new UserService(postgres);
        service3.registerUser("Amit");

        // NOTICE: UserService code didn't change!
        // We just changed which Database implementation we pass
        // This is the POWER of loose coupling and dependency injection
    }
}