package org.example.concurrency.completableFuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class T7_CombiningAnyOFMultipleCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        T7_CombiningAnyOFMultipleCompletableFuture demo = new T7_CombiningAnyOFMultipleCompletableFuture();

        CompletableFuture<Double> stockFromApi1 = demo.getStockFromApi1();
        CompletableFuture<Double> stockFromApi2 = demo.getStockFromApi2();
        CompletableFuture<Double> stockFromApi3 = demo.getStockFromApi3();


        CompletableFuture<Object> completableFuture = CompletableFuture.anyOf(stockFromApi1, stockFromApi2, stockFromApi3);

        completableFuture.thenAccept(e -> System.out.println(e)).get();
    }




    private CompletableFuture<Double> getStockFromApi1(){
        return CompletableFuture.supplyAsync(() -> {
            delay(TimeUnit.SECONDS);
            return 878.8;
        });
    }
    private CompletableFuture<Double> getStockFromApi2(){
        return CompletableFuture.supplyAsync(() -> {
            delay(TimeUnit.SECONDS);
            return 111.2;
        });
    }
    private CompletableFuture<Double> getStockFromApi3(){
        return CompletableFuture.supplyAsync(() -> {
            delay(TimeUnit.SECONDS);
            return 654.1;
        });
    }


    private static void delay(TimeUnit timeUnit) {
        try {
            Random r = new Random();
            int num = r.nextInt(1, 3);
            timeUnit.sleep(num);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
