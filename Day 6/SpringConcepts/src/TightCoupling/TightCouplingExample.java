package TightCoupling;
// Step 1: Create a tightly coupled system

class MySQLDatabase {
    public void connect() {
        System.out.println("Connected to MySQL Database");
    }

    public void saveData(String data) {
        System.out.println("Saved to MySQL: " + data);
    }
}

class UserService {
    // PROBLEM: UserService is TIGHTLY COUPLED to MySQLDatabase
    // If we want to change to MongoDB, we have to modify UserService code
    private MySQLDatabase database = new MySQLDatabase();

    public void registerUser(String username) {
        database.connect();
        database.saveData(username);
        System.out.println("User registered: " + username);
    }
}

public class TightCouplingExample {
    public static void main(String[] args) {
        UserService service = new UserService();
        service.registerUser("Rahul");

        // What if business wants MongoDB instead of MySQL?
        // We have to CHANGE UserService code!
        // This is BAD design.
    }
}
