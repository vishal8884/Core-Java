package concorrency.course2.futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T2_CompletableFutures {
    public static void main(String[] args) {

        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);

        CompletableFuture.supplyAsync(() -> "Hello My Name is Vishal") // First step computation is async
                .thenApply(s -> s.toUpperCase()) // Runs in the same thread as the previous step
                .thenApply(s -> s + ".") // Runs in the same thread as the previous step
                .thenAccept(System.out::println); // Runs in the same thread as the previous step

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> "Hello My Name is Vishal", executorService1) // First step computation is async
                .thenApplyAsync(s -> s.toUpperCase(), executorService2) // Runs in a different thread as specified by executorService2
                .thenApplyAsync(s -> s + ".") // Runs in the same thread as the previous step
                .thenAccept(System.out::println); // Runs in the same thread as the previous step
    }
}
