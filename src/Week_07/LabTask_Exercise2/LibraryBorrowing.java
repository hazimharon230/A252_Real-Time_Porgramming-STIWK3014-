package Week_07.LabTask_Exercise2;

/*Name: Ahmad Hazim bin Haron Arrashid
Matric number: 302721*/
public class LibraryBorrowing {
    private static String studentName = null;

    public static void borrowBook(String studentName, String bookTitle) {
        System.out.println(studentName + " is borrowing: " + bookTitle);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(studentName + " has finished borrowing: " + bookTitle);
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
