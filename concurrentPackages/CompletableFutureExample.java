package concurrentPackages;

import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(500);
            return "Hello from Future!";
        });

        System.out.println("Result: " + future.get());

        // Completable Future
        CompletableFuture
                .supplyAsync(() -> "Hello")
                .thenApply(s -> s + " World")
                .thenAccept(System.out::println);

        // combining two futures

        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "Hello1");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "Hello2");

        CompletableFuture<String> f3 = f1.thenCombine(f2, (f1Result, f2Result) -> {
            System.out.println(f1Result);
            System.out.println(f2Result);

//            throw new RuntimeException("");

            return "Hello3";
        }).exceptionally(e -> {
            System.out.println("Got an exception");
            return "Don't know what to do!";
        });
        System.out.println(f3.get());

        executorService.shutdown();
    }
}
