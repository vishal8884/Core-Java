package Java8.CompletableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FutureDemoExecutorsSumit {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<List<Integer>> future = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Current Thread is :: "+Thread.currentThread().getName());
            return Arrays.asList(1, 2, 3);
        });

        Future<List<Integer>> future2 = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Current Thread is :: "+Thread.currentThread().getName());
            return Arrays.asList(1, 2, 3);
        });

        Future<List<Integer>> future3 = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Current Thread is :: "+Thread.currentThread().getName());
            return Arrays.asList(1, 2, 3);
        });

        Future<?> future4 = executorService.submit(() -> System.out.println("hello "+Thread.currentThread().getName()));

        System.out.println("Running");

        List<Integer> integers = future.get();

        //disadvantages
        //1) Future cannot be completed manually in case of delay
        //2) chaining of futures cannot be done (eg future 1 waiting for future 2 and 3 in different thread)
        //3) Proper exception handling in Future
        System.out.println("Completed execution :: "+integers);
    }
}
