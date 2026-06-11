package Week_09;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class MainSumTask {
        public static void main(String[] args) {
            int[] nums = new int[10_000];
            for(int i = 0; i < nums.length; i++) {
                nums[i] = i;
            }
            ForkJoinPool pool = new ForkJoinPool();
            long result = pool.invoke(new SumTask(nums, 0, nums.length));

            System.out.println("Total sum: " + result);
        }
}
