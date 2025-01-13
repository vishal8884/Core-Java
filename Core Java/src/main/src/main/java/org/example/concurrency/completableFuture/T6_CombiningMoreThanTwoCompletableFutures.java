package org.example.concurrency.completableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class T6_CombiningMoreThanTwoCompletableFutures {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        T6_CombiningMoreThanTwoCompletableFutures demo = new T6_CombiningMoreThanTwoCompletableFutures();

        CompletableFuture<String> weatherComFuture = demo.getWeatherComFuture();
        CompletableFuture<String> newsComFuture = demo.getNewsComFuture();
        CompletableFuture<String> stockComFuture = demo.getStockComFuture();


        System.out.println("Going to Combine Weather,news and stock future start :: "+Thread.currentThread().getName());
        CompletableFuture<Void> future = CompletableFuture.allOf(weatherComFuture, newsComFuture, stockComFuture);
        System.out.println("Going to Combine Weather,news and stock future done :: "+Thread.currentThread().getName());

        List<Details> detailsList = new ArrayList<>();

        future.thenRun(() -> {
            String weather = weatherComFuture.join();
            String news = newsComFuture.join();
            String stock = stockComFuture.join();

            detailsList.add(new Details(weather,news,stock));

            System.out.println("Aggregated Data ::");
            System.out.println("Weather :: "+weather+"    news :: "+news+"     stock :: "+stock);
        }).get();

        //or you can just do future.get()


        System.out.println("*****************Waiting for process to be Done*********************");
        delay(2);
        System.out.println("*****************Waited for 2 seconds*********************");

        System.out.println("All the process done "+detailsList);
    }



    //******************************Private Utils***************************************//
    private CompletableFuture<String> getWeatherComFuture(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Geting Weather details :: "+Thread.currentThread().getName());
            delay(1);
            return "Winter Cool";
        });
    }


    private CompletableFuture<String> getNewsComFuture(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting News details :: "+Thread.currentThread().getName());
            delay(1);
            return "Latest Java 23 Released";
        });
    }


    private CompletableFuture<String> getStockComFuture(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting stock details :: "+Thread.currentThread().getName());
            delay(1);
            return "APPL 20 USD. STO CK DC CRA SH ED";
        });
    }

    private static void delay(int sec) {
        String timeUnits = "seconds";
        try {
            TimeUnit timeUnit = switch (timeUnits)  {
                case "Seconds","seconds" -> TimeUnit.SECONDS;
                case "Minutes","minutes" -> TimeUnit.MINUTES;
                case "ms","milliseconds" -> TimeUnit.MILLISECONDS;
                default -> throw new IllegalStateException("Unexpected value: " + timeUnits);
            };


            timeUnit.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    private record Details(String weather,String news,String stock){}
}
