import java.util.ArrayList;
import java.util.Collections;
public class GradeManager {
    private ArrayList<Student>students;
    public GradeManager(){
        students = new ArrayList<>();
    }
    //Add a new student
    public void addStudent(Student student){
        if(findStudent(student.getId()) != null){
            System.out.println("Student ID already exists!");
            return;
        }
        students.add(student);
        System.out.println("Student added successfully!");
    }
    //Find student using ID
    public Student findStudent(int id){
        for (Student student : students){
            if(student.getId()==id){
                return student;
            }
        }
        return null;
    }
    //Display all students
    public void displayStudents() {
    if (students.isEmpty()) {
        System.out.println("No students available.");
        return;
    }

    System.out.printf(
        "%-10s %-20s %-30s %-10s %-10s%n",
        "ID", "Name", "Marks", "Average", "GPA"
    );

    System.out.println(
        "------------------------------------------------------------------------------------------"
    );

    for (Student student : students) {
        System.out.printf(
            "%-10d %-20s %-30s %-10.2f %-10.2f%n",
            student.getId(),
            student.getName(),
            student.getGrades(),
            student.getAverage(),
            student.getGPA()
        );
    }
}
    


// Add these methods inside GradeManager class

public double getClassAverage() {
    if (students.isEmpty()) {
        return 0.0;
    }

    double total = 0;

    for (Student student : students) {
        total += student.getAverage();
    }

    return total / students.size();
}

public double getClassMedian() {
    if (students.isEmpty()) {
        return 0.0;
    }

    ArrayList<Double> averages = new ArrayList<>();

    for (Student student : students) {
        averages.add(student.getAverage());
    }

    Collections.sort(averages);

    int n = averages.size();

    if (n % 2 == 1) {
        return averages.get(n / 2);
    }

    return (averages.get(n / 2 - 1)
          + averages.get(n / 2)) / 2.0;
}

}
