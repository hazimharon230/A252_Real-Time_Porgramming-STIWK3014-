package Individual_Assignment;

import java.util.concurrent.CopyOnWriteArrayList;

public class Task_1 {
    static CopyOnWriteArrayList<String> registerCourse = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 50; i++) {
            registerCourse.add("Course registration " + i + ": STIWK3014");
        }

        System.out.println("***** REGISTRATION RECORDS *****");
        for (String registrationRec: registerCourse) {
            System.out.println(registrationRec);
        }

        System.out.println("\nTotal number of registration request: " + registerCourse.size());

        String searchCourse = "Course registration 7: STIWK3014";
        System.out.println(" ");
        System.out.println(searchCourse + " exist ?" + " Answer: " + registerCourse.contains(searchCourse));

        System.out.println("\nRegistration record at index position 10 is: " + registerCourse.get(10));
    }
}