//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class NoteApp {
    private final String FILENAME = "notes.txt";
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<String> notes = new ArrayList<>();

    public NoteApp() {// loadNotes inside the constructor so when object created program run after restart notes will come in arraylist and then we display method from this arraylist
        loadNotes();
    }


    public void addNote() {
        System.out.println("Enter you notes");
        String str = scanner.nextLine();
        notes.add(str);
        System.out.println("Note added successfully");
        System.out.println();
        saveNotes();


    }

    public void displayNotes() {
        if (notes.isEmpty()) {
            System.out.println("There do not exist any notes");
            return;
        }
        System.out.println("\n=== YOUR NOTES ===");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i));
        }
        System.out.println();

    }

    public void deleteNotes() {
        displayNotes();
        System.out.println("Enter note number to delete:");
        try {
            int index = scanner.nextInt() -1;
            if (index >= 0 && index < notes.size()) {
                //remonving from arrayList
                notes.remove(index);
                saveNotes();
                System.out.println("Note deleted!");
            } else {
                System.out.println("Invalid number.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
            scanner.nextLine();
        }

    }

    private void saveNotes() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME)); //true is there to add at end of file
            for (String s : notes) {
                writer.write(s);
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //to load notes to arraylist to access when restart app
    private void loadNotes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                notes.add(line);//addding to arraylist
            }

        } catch (FileNotFoundException e) {
            // File doesn't exist yet, that's ok
        } catch (IOException e) {
            System.out.println("Error loading notes: " + e.getMessage());
        }

    }

    public void showMenu() {
        while (true) {
            System.out.println("==== NOTE APP ====");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Delete Notes");
            System.out.println("4. Exit");
            System.out.println("Choose");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addNote();
                        break;
                    case 2:
                        displayNotes();
                        break;
                    case 3:
                        deleteNotes();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("invalid choice ");
                }
            } catch (Exception e) {
                System.out.println("Invalid input!");
                scanner.nextLine();
            }
        }

    }

}


public class Main {
    public static void main(String[] args) {
        NoteApp obj = new NoteApp();
        obj.showMenu();

    }
}