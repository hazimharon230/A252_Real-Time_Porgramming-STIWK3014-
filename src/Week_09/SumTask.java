package Week_09;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

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
        if (end - start <= 5) {
            long sum = numbers[start];

            for (long i = start + 1; i < end; i++) {
                if (numbers[Math.toIntExact(i)] > sum) {
                    sum += numbers[Math.toIntExact(i)];
                }
            }
            return (long) sum;
        }
        int mid = start + end/2;

        SumTask left = new SumTask(numbers, start, mid);
        SumTask right = new SumTask(numbers, start, end);

        left.fork();

        long rightSum = right.compute();
        long leftSum = left.join();

        return Math.addExact(leftSum, rightSum);
    }
}