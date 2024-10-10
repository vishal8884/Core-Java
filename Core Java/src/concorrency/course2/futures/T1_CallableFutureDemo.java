package concorrency.course2.futures;

import java.util.concurrent.*;

public class T1_CallableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> stringFuture = executorService.submit(fetchCallable());

        while(!stringFuture.isDone()) {
            System.out.println("still waiting for future");
        }
        String s = stringFuture.get();
        System.out.println(s);

    }

    private static Callable<String> fetchCallable(){
        return () -> {
            System.out.println("Starting callable");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Callable Completed");

            return "Hello World";
        };
    }
}
