package concorrency.course2.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Runner implements Runnable{

    int n;
    public Runner(int n){
        this.n = n;
    }

    @Override
    public void run() {
        long duration = (long) (Math.random() * 5);
        System.out.println("n :: "+n+"    Thread :: "+Thread.currentThread().getName()+"    duration for sleep :: "+duration);

        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


public class T1_SingleThreadExecutors {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for(int i=0;i<10;i++){
            executorService.execute(new Runner(i));
        }

        executorService.shutdown();
    }
}
