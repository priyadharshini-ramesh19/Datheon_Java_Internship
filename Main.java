
import java.util.Scanner;

public class Main {

    public static int readInt(Scanner sc, String message, int min, int max) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();

            try {
                int number = Integer.parseInt(input);

                if (number >= min && number <= max) {
                    return number;
                }

                System.out.println("Invalid input! Enter " + min + " to " + max + ".");

            }
            catch (NumberFormatException e) {
                System.out.println("Please enter numbers only!");
            }
        }
    }

    // Empty text validation
    public static String readText(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();

            if (input.length() > 0) {
                return input;
            }

            System.out.println("Input cannot be empty!");
        }
    }

   
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeManager manager = new GradeManager();

        int choice;

        do {
            System.out.println("\n===== STUDENT GRADE MANAGEMENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Student Marks");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Calculate Class Average");
            System.out.println("6. Calculate Class Median");
            System.out.println("7. Exit");
           

            choice = readInt(sc, "Enter your choice: ", 1, 7);

            switch (choice) {

                case 1:
                    int id = readInt(sc, "Enter Student ID: ", 1,Integer.MAX_VALUE);

                     String name = readText(sc, "Enter Student Name: ");

                    Student student = new Student(id, name);
                    manager.addStudent(student);
                    break;

                case 2:
                    int searchId = readInt(sc, "Enter Student ID: ", 1, Integer.MAX_VALUE);

                    Student s = manager.findStudent(searchId);

                    if (s != null) {
                       
                        String subject = readText(sc,"Enter Subject: ");
                        int mark = readInt(sc, "Enter Mark(0-100):", 0, 100);

                        s.addGrade(subject, mark);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 3:
                    int findId = readInt( sc, "Enter Student ID: ", 1, Integer.MAX_VALUE);

                    Student found = manager.findStudent(findId);

                    if (found != null) {
                        System.out.println("ID: " + found.getId());
                        System.out.println("Name: " + found.getName());
                        System.out.println("Marks: " + found.getGrades());
                        System.out.printf(
                            "Average: %.2f%n", found.getAverage()
                        );
                        System.out.printf(
                            "Sample GPA: %.2f%n", found.getGPA()
                        );
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    manager.displayStudents();
                    break;

                case 5:
                    System.out.printf(
                        "Class Average: %.2f%n",
                        manager.getClassAverage()
                    );
                    break;

                case 6:
                    System.out.printf(
                        "Class Median: %.2f%n",
                        manager.getClassMedian()
                    );
                    break;

                case 7:
                    System.out.println("Thank you! Exiting...");
                    break;

                default:
                    System.out.println(
                        "Invalid choice! Enter 1 to 7."
                    );
            }

        } while (choice != 7);

        sc.close();
    }
}

