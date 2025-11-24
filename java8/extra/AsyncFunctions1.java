package java8.extra;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncFunctions1 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        CompletableFuture.supplyAsync(() -> "Hello", executor)
                .thenApplyAsync(x -> x + " World!", executor)
                .thenAccept(System.out::println)
                .thenRun(executor::shutdown);
    }
}
