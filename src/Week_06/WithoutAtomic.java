package Week_06;
//use data 100,000 increments

public class WithoutAtomic {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {  //Lambda to create non-class/method
            for(int i =0; i < 100000; i++) {
                count++; //not atomic
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count with no atomic: " + count);
        //System.out.println("Thread 2 printing 100,000");
    }
}
