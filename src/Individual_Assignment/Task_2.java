package Individual_Assignment;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class Task_2 {
    public static void main(String[] args) throws InterruptedException {
        Set<String> courseCodes = new ConcurrentSkipListSet<>();

        courseCodes.add("SCCVK2013");
        courseCodes.add("MPU1052");
        courseCodes.add("STIJK2014");
        courseCodes.add("STIQK2113");

        courseCodes.add("SCCVK2013"); //try to duplicate same course code

        System.out.println("Total Unique Course Code: " + courseCodes.size());
        System.out.println("All Course Code (Unique): ");
        System.out.println(courseCodes);
        System.out.println(" ");

        System.out.println("Does the list of course code contains MPU1052? " + courseCodes.contains("MPU1052"));

        courseCodes.remove("MPU1052");

        System.out.println("\nTotal Unique Course after removal: " + courseCodes.size());
        System.out.println("All Unique Course Code (After Removal MPU1052): ");
        System.out.println(courseCodes);
    }
}