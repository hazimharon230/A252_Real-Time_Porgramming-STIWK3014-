package Week_06;
//AtomicInteger ----count.IncrementandGet()

import java.util.concurrent.atomic.AtomicInteger;

public class WithAtomic {
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {  //Lambda to create non-class/method
            for(int i =0; i < 100000; i++) {
                count.incrementAndGet(); // atomic Thread safe
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

        System.out.println("Final count atomic: " + count.get());
        //System.out.println("Thread 2 printing 100,000");
    }
}
