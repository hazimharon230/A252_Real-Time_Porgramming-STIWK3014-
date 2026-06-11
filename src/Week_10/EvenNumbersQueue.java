package Week_10;

/*import java.util.ArrayList;
import java.util.List;*/
import java.util.concurrent.ConcurrentLinkedQueue;

public class EvenNumbersQueue {

    static ConcurrentLinkedQueue<Integer> queue =
            new ConcurrentLinkedQueue<>();

    public static void main(String[] args)
            throws InterruptedException {

        Thread producer = new Thread(() -> {

            for(int i=1;i<=20;i++){

                if(i % 2 == 0){

                    queue.offer(i); //we need to adds the item to the queue

                    System.out.println(
                            "Produced: " + i);
                }
            }

        });

        Thread consumer = new Thread(() -> {

            while(true){

                Integer num = queue.poll();

                if(num != null){

                    System.out.println(
                            "Processed: " + num);
                }

                if(queue.isEmpty()){
                    break;
                }
            }

        });

        producer.start();

        producer.join();

        consumer.start();

        consumer.join();
    }
}
