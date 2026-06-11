package Week_09.LabTask_Exercise5;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MinMaxTask extends RecursiveTask<int[]> {
    private static final int THRESHOLD = 4;
    private int[] array;
    private int start, end;

    public MinMaxTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected int[] compute() {
        int size = end - start;

        //
        if (size <= THRESHOLD) {
            int min = array[start];
            int max = array[start];

            for (int i = start + 1; i < end; i++) {
                if (array[i] < min) min = array[i];
                if (array[i] > max) max = array[i];
            }
            return new int[]{min, max};
        }

        int mid = start + size/2;
        MinMaxTask leftTask = new MinMaxTask(array, start, mid);
        MinMaxTask rightTask = new MinMaxTask(array, mid, end);

        leftTask.fork();
        int[] rightResult = rightTask.compute();
        int[] leftResult = leftTask.join();

        //combine results
        return new int[] {
                Math.min(leftResult[0], rightResult[0]),
                Math.max(leftResult[1], rightResult[1])
        };
    }

    public static void main(String[] args) {
        int[] array = {12, 5, 88, 19, 20, 3, 40, 7, 18, 21, 50, 60};

        ForkJoinPool pool = new ForkJoinPool();
        MinMaxTask task = new MinMaxTask(array, 0, array.length);
        int[] result = pool.invoke(task);

        System.out.println("Min Value: " + result[0]);
        System.out.println("Max Value: " + result[1]);
    }
}