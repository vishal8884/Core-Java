package Java8.CompletableFuture;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureRunAsyncDemo {
    public static void main(String[] args) {

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            sleep(2);
            System.out.println("First Async runnable called");
        });

        CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(() -> {
            sleep(1);
            System.out.println("Second Async runnable called");
        });

        CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            System.out.println("Third Async runnable called");
            return "hello";
        });

        completableFuture.thenCombine(completableFuture3,(result1,result2) -> "test = "+result2);

        completableFuture.join();
        completableFuture2.join();

    }

    private static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
