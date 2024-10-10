package concorrency.course2.futures;

import java.util.concurrent.CompletableFuture;

public class T3_CompletableFutureCombineResult {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> "Hello")
                .thenCombine(CompletableFuture.supplyAsync(() -> "World"),(s1,s2) -> s1+"-"+s2)
                .thenApply(s -> s.toUpperCase())
                .thenAccept(System.out::println);
    }
}
