package Week_06;

import java.util.concurrent.atomic.AtomicInteger;

public class Account {
    private AtomicInteger balance;
    private final String name;

    public Account (String name, int balance) {
        this.name = name;
        this.balance = new AtomicInteger(balance);
    }

    public void withdraw (int amount) {
        balance.addAndGet(-amount);
    }

    public void deposit (int amount) {
        balance.addAndGet(+amount);
    }

    public int getBalance() {
        return balance.get();
    }

    public String getName() {
        return name;
    }
}
