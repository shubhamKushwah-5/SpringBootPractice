import java.util.Scanner;
import java.util.ArrayList;

class StudentManager{

    private ArrayList<String> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent(){
        System.out.println("Please enter student name");
        String name = scanner.nextLine();
        students.add(name);
        System.out.println(" yeah " + name + "added successfully! ");

    }

    public void displayStudent(){
        if(students.isEmpty()){
            System.out.println("No students found");
            return ;
        }
        System.out.println("======= STUDENT LIST BELOW =======");
//        for(String s :students){
//            System.out.println(s);
//        }

        for(int i = 0; i < students.size(); i++){
            System.out.println((i+1) + "." + students.get(i));
        }

    }

    public void searchStudent(){
        System.out.println("Please enter student name to search");
        String name = scanner.nextLine();

        if(students.contains(name)){
            System.out.println("found " + name);
        }else {
            System.out.println("Student not found");
        }

    }

    public void removeStudent(){
        System.out.println("enter student name to be removed");
        String name = scanner.nextLine();
        if(students.remove(name)){
            System.out.println(name + "removed successfully");
        }else{
            System.out.println(name + "not found in directory");
        }

    }

    public void showMenu() {
        while (true) {
            System.out.println("\n=== STUDENT MANAGER ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    System.out.println("goood bye");
                    return;
                default:
                    System.out.println("invalid option choosen");
            }

        }
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("welcome to student Manager");
        StudentManager manager = new StudentManager();
        manager.showMenu();
    }
}