package concorrency.course2.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class FixedThreadPoolRunner implements Runnable{

    int n;
    public FixedThreadPoolRunner(int n){
        this.n = n;
    }

    @Override
    public void run() {
        long duration = (long) (Math.random() * 5);
        System.out.println("n :: "+n+"    sleep duration :: "+duration+"    Thread-id :: "+Thread.currentThread().getId());

        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


//1) In FixedThreadPool n number of threads are allocated
//2) These threads perform tasks paralley and pick up next tasks
//3) example 4 threads are running parallely after its done same 4 threads will pick up next tasks and run parallely and so on

public class T2_FixedThreadPoolExecutors {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for(int i=0;i<50;i++){
            executorService.execute(new FixedThreadPoolRunner(i));
        }

        executorService.shutdown();
    }
}
