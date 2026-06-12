package Individual_Assignment;

import java.util.concurrent.ConcurrentHashMap;
public class Task_3 {
    static ConcurrentHashMap<Integer, String> studentCourses = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 50; i++) {
            studentCourses.put(i, "Course" + (i % 5 + 1));
        }

        System.out.println("Before set index to the course name:");
        System.out.println("Student 50 registered: " + studentCourses.get(50));

        studentCourses.replace(50, "Human Computer Interaction");
        System.out.println("\nAfter set index to the course name:");
        System.out.println("Student 50 registered: " + studentCourses.get(50));

        System.out.println("\nStudent ID 35 Exists? " + studentCourses.containsKey(35));

        System.out.println("\nAll registered students: " + studentCourses);
    }
}