package concurrentPackages;

import java.util.concurrent.*;

public class FutureAndCallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Callable<String> task1 = new Callable<>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "Task1 Completed";
            }

            @Override
            public String toString() {
                return "task1";
            }
        };

        Callable<String> task2 = () -> {
            Thread.sleep(2000);
            return "Task2 Completed";
        };

        Future<String> future1 = executor.submit(task1);
        Future<String> future2 = executor.submit(task2);

        System.out.println("Main thread is doing something else...");
        System.out.println("task1 is done: " + future1.isDone());

        System.out.println("future1: " + future1);
        System.out.println("future2: " + future2);

        future2.cancel(true);

        String result1 = future1.get();
        System.out.println("Callable task1 result: " + result1);

        if (!future2.isCancelled()) {
            String result2 = future2.get();
            System.out.println("Callable task2 result: " + result2);
        } else {
            System.out.println("task2 is cancelled!");
        }

        future1.cancel(true);

        System.out.println("future1: " + future1);
        System.out.println("future2: " + future2);

        executor.shutdownNow();
    }
}
