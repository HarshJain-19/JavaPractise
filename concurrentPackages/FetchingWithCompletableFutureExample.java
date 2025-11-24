package concurrentPackages;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FetchingWithCompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletableFuture<Void> pipeline = CompletableFuture
                .supplyAsync(FetchingWithCompletableFutureExample::fetchData, executorService)
                .thenApply(FetchingWithCompletableFutureExample::processData)
                .thenCompose(data -> saveToDatabase(data))
                .thenAccept(saveId -> System.out.println("Data Saved Successfully... \nwith saved ID: " + saveId))
                .exceptionally(err -> {
                    System.err.println("Error occurred... \nerror message: " + err.getMessage());
                    return null;
                });

        pipeline.get();
        executorService.shutdown();
    }

    public static String fetchData() {
        simulate("fetching user data...");
        return "{name: 'John Doe', post: 'Chief'}";
    }

    public static String processData(String data) {
        simulate("processing data...");
        return data.toLowerCase();
    }

    public static CompletableFuture<Integer> saveToDatabase(String data) {
        simulate("saving processed data to DB...");
        return CompletableFuture.supplyAsync(() -> 101);
    }

    public static void simulate(String action) {
        System.out.println(Thread.currentThread().getName() + ": " + action);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {}
    }
}
