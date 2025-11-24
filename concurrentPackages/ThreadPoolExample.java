package concurrentPackages;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService threadPool1 = Executors.newFixedThreadPool(3);
        ExecutorService threadPool2 = Executors.newCachedThreadPool();

        for (int i = 0; i <= 5; i++) {
            threadPool1.submit(new RunnableTask(i));
//            threadPool2.submit(new RunnableTask(i));
        }

        threadPool1.shutdown();
        threadPool2.shutdown();
    }

    static class RunnableTask implements Runnable {
        private final int taskId;

        public RunnableTask(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(Math.abs(3 - taskId) * 1000L);
            } catch (Exception ignored) {}

            System.out.println("Executing Task " + taskId + " in " + Thread.currentThread().getName());
        }
    }

}
