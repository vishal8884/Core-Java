package concorrency.course2.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Processor implements Callable<String> {
    int id;

    public Processor(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "Processor with id "+id+"  Called!";
    }
}

public class T4_CallableExample {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<String>> futureResults = new ArrayList<>();

        for(int i=0;i<=20;i++){
            Future<String> futureResult = executorService.submit(new Processor(i));
            futureResults.add(futureResult);
        }

        for(Future<String> futureResult : futureResults){
            try {
                System.out.println("futureResult :: "+futureResult.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }


        executorService.shutdown();
    }
}
