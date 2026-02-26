import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class PhoneBook{
    //created hashmap to store name and phoneNumber
    private HashMap <String, String> contacts = new HashMap<>();
    //scanner to get user input
    private Scanner scanner = new Scanner(System.in);

    public void addContact(){
        System.out.println("Please enter Name");
        String name = scanner.nextLine();
        System.out.println("Please enter phone Number");
        String phoneNumber = scanner.nextLine();
        //add to hashmap
        contacts.put(name,phoneNumber);
        System.out.println("Details added Successfully" + name);

    }

    public void findContact(){
        if (contacts.isEmpty()){
            System.out.println("cant find as contact are empty");
        }

        System.out.println("Please enter name you want contact for");
        String name = scanner.nextLine();
        if(contacts.containsKey(name)){
            System.out.println("phone Number" + contacts.get(name));
        }else{
            System.out.println("not found");
        }
    }

    public void displayAllContacts(){
        if (contacts.isEmpty()){
            System.out.println("No ocntacts saved");
            return;
        }
        System.out.println("====All Contacts====");
        for(String name: contacts.keySet()){
            System.out.println(name + ":" +contacts.get(name));
        }

    }

    public void updateContacts() {
        System.out.println("enter user name you want to update contact for");
        String name = scanner.nextLine();
        if (contacts.containsKey(name)) {
            System.out.println("Please enter new contact number");
            String phoneNumber = scanner.nextLine();
            contacts.put(name, phoneNumber);
            System.out.println("Details added successfully");
        }
        System.out.println("The entered contact doesn't exist in contact");
    }

    public void deleteContact(){
        if (contacts.isEmpty()){
            System.out.println("cant delete as no contact found");
        }

        System.out.println("Please enter name to delete");
        String name = scanner.nextLine();
        if(contacts.containsKey(name)){
            contacts.remove(name);
            System.out.println(name + " contact deleted successfully");
        }

    }

    public void menu(){
        while(true){
            System.out.println("\n=== PHONEBOOK ===");
            System.out.println("1. Add Contact");
            System.out.println("2. Find Contact");
            System.out.println("3. Display All");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); //to consume buffer /n stored

            switch (choice){
                case 1:
                    addContact();
                    break;
                case 2:
                    findContact();
                    break;
                case 3:
                    displayAllContacts();
                    break;
                case 4:
                    updateContacts();
                    break;
                case 5:
                    deleteContact();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("invalid choice");

            }


        }
    }
}

public class Main {
    public static void main(String[] args) {
        PhoneBook ph = new PhoneBook();
        ph.menu();
    }
}