package Week_07.LabTask_Execerise4;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class HospitalRegistrationWithReentrantReadWriteLock {
    private static int totalPatients = 0;
    private static final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private static final ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();
    private static final ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable registerPatient = () -> {
            for(int i = 0; i < 100000; i++) {
                writeLock.lock();
                try {
                    totalPatients++;
                } finally {
                    writeLock.unlock();
                }
            }
        };

        Thread counter1 = new Thread(registerPatient, "Counter-1");
        Thread counter2 = new Thread(registerPatient, "Counter-2");

        counter1.start();
        counter2.start();

        counter1.join();
        counter2.join();

        readLock.lock();
        try {
            System.out.println("Total Registered Patients: " + totalPatients);
        } finally {
            readLock.unlock();
        }
    }
}