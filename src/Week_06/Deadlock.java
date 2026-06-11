package Week_06;

public class Deadlock {
    public static void transfer (Account from, Account to, int amount) {
        from.withdraw(amount);
        to.deposit(amount);
        System.out.println(Thread.currentThread().getName()
                + " transferred. \nFrom: " + from.getName()
                + "\tAmount Transffered" + from.getBalance()
                + "\n To: " + to.getName() + "\tAmount: " + to.getBalance());
    }

    public static void main (String[] args) {
        Account A = new Account("A", 1000);
        Account B = new Account("B", 1000);

        Thread t1 = new Thread(() -> transfer(A, B,100));
        Thread t2 = new Thread(() -> transfer (A, B, 200));

        t1.start();
        t2.start();
    }
}
