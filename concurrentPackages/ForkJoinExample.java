package concurrentPackages;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample extends RecursiveTask<Long> {
    private final long[] array;
    private final int start, end;
    private static final int THRESHOLD = 500;

    public ForkJoinExample(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (start - end <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            ForkJoinExample left = new ForkJoinExample(array, start, mid);
            ForkJoinExample right = new ForkJoinExample(array, mid, end);

            left.fork();
            long rightResult = right.compute();
            long leftResult = left.join();

            return leftResult + rightResult;
        }
    }

    public static void main(String[] args) {
        long[] number = new long[10000];
        for (int i = 0; i < number.length; i++) number[i] = i + 1;

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinExample task = new ForkJoinExample(number, 0, number.length);

        long result = pool.invoke(task);
        System.out.println("Sum: " + result);
    }
}
