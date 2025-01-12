package org.example.concurrency.completableFuture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.*;

public class T1_DisadvantagesOfFuture {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<ArrayList<Integer>> future = executorService.submit(() -> {
            delay(1);
            return new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        });

        ArrayList<Integer> integers = future.get();
        System.out.println(integers);

    }

    private static void delay(int min) {
        try {
            TimeUnit.MINUTES.sleep(min);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
