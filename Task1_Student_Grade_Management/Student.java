
import java.util.HashMap;
import java.util.Map;

public class Student {
    private int id;// stores st id
    private String name; //st name 
    private Map<String, Integer> grades;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getGrades() {
        return java.util.Collections.unmodifiableMap(grades);
    }

    public void addGrade(String subject, int mark) {
        subject=subject.trim();
        if (subject.isEmpty()) {
        System.out.println("Subject cannot be empty!");
        return;
    }

        for (String existingSubject : grades.keySet()) {

        if (existingSubject.equalsIgnoreCase(subject)) {
        System.out.println("Subject already exists! Cannot add duplicate subject.");
        return;
    }
}
        if (mark < 0 || mark > 100) {
            System.out.println("Marks must be between 0 and 100.");
            return;
        }

        grades.put(subject, mark);
        System.out.println("Mark added successfully!");

    }
        
    // Calculate student's average marks
    public double getAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        int total = 0;

        for (int mark : grades.values()) {
            total += mark;
        }

        return (double) total / grades.size();
    }

    // Calculate simplified GPA on a 10-point scale
    public double getGPA() {
        return getAverage() / 10.0;
    }

    
}
