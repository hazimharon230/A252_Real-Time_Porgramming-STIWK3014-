package Week_07.LabTask_Exercise2;

import java.util.concurrent.locks.ReentrantLock;

public class LibraryWithReentrantLock {
    private static String studentName = null;

    private static final ReentrantLock borrowingCard = new ReentrantLock();

    public static void borrowBook(String studentName, String bookTitle) {
        //System.out.println(studentName + " is borrowing: " + bookTitle);
        borrowingCard.lock();
        try {
            System.out.println(" [" + studentName +"] Borrowing: \"" + bookTitle +
                    "\" | lock Count: " + borrowingCard.getHoldCount());
            Thread.sleep(1000);
            System.out.println(" [" + studentName +"] Done Borrowing: \"" + bookTitle + "\"");
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
            borrowingCard.unlock();
        }
        //System.out.println(studentName + " has finished borrowing: " + bookTitle);
    }

    public static void borrowingSession(String studentName, String books) {
        System.out.println("\n" + studentName + " approaching the counter...");
        borrowingCard.lock();
        try {
            System.out.println(">> " + studentName + "acquire the borrowing card.");
            System.out.println(" Waiting students: " + borrowingCard.getQueueLength());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            borrowingCard.unlock();
            System.out.println(">> " + studentName + " returneed the borrowing card. \n");
        }
    }

    public static void main(String[] args) {
        Runnable student1 = () -> {
            borrowBook("Abu", "Boboiboy");
            borrowBook("Abu", "Ejen Ali");
        };

        Runnable student2 = () -> {
            borrowBook("Ali", "Duit Aku, Hidup Aku");
        };

        Runnable student3 = () -> {
            borrowBook("Kasim", "Think And Grow Rich");
        };

        Thread t1 = new Thread(student1, "Student-Abu");
        Thread t2 = new Thread(student2, "Student-Ali");
        Thread t3 = new Thread(student3, "Student-Kasim");

        t1.start();
        t2.start();
        t3.start();
    }
}
