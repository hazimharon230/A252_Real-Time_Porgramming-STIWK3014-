package Individual_Assignment;

import java.util.concurrent.ConcurrentLinkedQueue;
public class Task_4 {
    static ConcurrentLinkedQueue<String> reqQueue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {
        reqQueue.offer("Req-A");
        reqQueue.offer("Req-B");
        reqQueue.offer("Req-C");
        reqQueue.offer("Req-D");

        System.out.println("First Request is: " + reqQueue.peek());

        while(!reqQueue.isEmpty()) {
            System.out.println("Processing: " + reqQueue.poll());
        }

        System.out.println("\n Queue is empty? " + reqQueue.isEmpty());
    }
}