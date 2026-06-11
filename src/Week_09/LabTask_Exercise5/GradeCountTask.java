package Week_09.LabTask_Exercise5;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;
import java.util.Arrays;

public class GradeCountTask extends RecursiveTask<int[]> {
    //grade counts index: 0=A, 1=B, 2=C, 3=D, 4=F
    private static final int THRESHOLD = 4;
    private int[] scores;
    private int start, end;

    public GradeCountTask(int[] scores, int start, int end) {
        this.scores = scores;
        this.start = start;
        this.end = end;
    }

    private int getGradeIndex(int markah) {
        if (markah >= 85) return 0; //A
        if (markah >= 70) return 1; //B
        if (markah >= 55) return 2; //C
        if (markah >= 40) return 3; //D
        return 4; //F
    }

    @Override
    protected int[] compute() {
        int size = end - start;

        if (size <= THRESHOLD) {
            int[] counts = new int[5];

            for (int i = start; i < end; i++) {
                counts[getGradeIndex(scores[i])]++;
            }
            return counts;
        }

        int mid = start + size/2;
        GradeCountTask leftTask = new GradeCountTask(scores, start, mid);
        GradeCountTask rightTask = new GradeCountTask(scores, mid, end);

        leftTask.fork();
        int[] rightResult = rightTask.compute();
        int[] leftResult = leftTask.join();

        int[] combined = new int[5];
        for (int i = 0; i < 5; i++) {
            combined[i] = leftResult[i] + rightResult[i];
        }
        return combined;
    }

    public static void main(String[] args) {
        int[] scores = {75, 88, 92, 55, 63, 79, 100, 82, 45, 38, 67, 73, 89, 95, 50};

        System.out.println("Scores: " + Arrays.toString(scores));

        ForkJoinPool pool = new ForkJoinPool();
        GradeCountTask task = new GradeCountTask(scores, 0, scores.length);
        int[] result = pool.invoke(task);

        System.out.println("\nGrade Distributions:");
        System.out.println("A (85 - 100): " + result[0] + " students");
        System.out.println("B (70 - 84): " + result[1] + " students");
        System.out.println("C (55 - 69): " + result[2] + " students");
        System.out.println("D (40 - 54): " + result[3] + " students");
        System.out.println("F (0 - 39): " + result[4] + " students");
    }
}