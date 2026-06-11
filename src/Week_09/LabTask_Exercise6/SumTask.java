package Week_09.LabTask_Exercise6;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent. ForkJoinPool;

public class SumTask extends RecursiveTask<Long>{
    private int[] numbers;
    private int start, end;
    private static final int THRESHOLD = 1000;

    public SumTask(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;

        if (length <= THRESHOLD) {
            long sum = 0;

            for (int i = start; i < end; i++) {
                sum += numbers [i];
            }
            return sum;
        }

        int mid = start + length/2;
        SumTask leftTask = new SumTask(numbers, start, mid);
        SumTask rightTask = new SumTask(numbers, mid, end);

        leftTask.fork();
        long rightResult = rightTask.compute();
        long leftResult = leftTask.join();

        return leftResult + rightResult;
    }
}

