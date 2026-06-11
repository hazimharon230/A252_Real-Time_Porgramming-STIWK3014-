package Week_06;

public class Synchronization {
    private static int count = 0;
    public static synchronized void increment() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for(int i = 0; i < 100000; i++) {
                increment(); //for synchronization -> thread more safe
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        Thread t4 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Final Count (Synchronization): " + count);
    }
}
