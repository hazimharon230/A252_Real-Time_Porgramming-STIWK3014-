package Week_04.ThreadYield;

public class ThreadYield extends Thread {
    private String name;

    public ThreadYield(String name) {
        this.name = name;
    }

    public void run() {
        for (int i =0; i<=5; i++) {
            System.out.println(name + " : " + i);

            Thread.yield();
        }
    }
}
