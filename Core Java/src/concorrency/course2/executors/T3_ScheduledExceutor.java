package concorrency.course2.executors;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class StockMarketUpdater implements Runnable{

    @Override
    public void run() {
        System.out.println("Downloading and updating stocks..Data :: Thread-id :: "+Thread.currentThread().getId());
    }
}


public class T3_ScheduledExceutor {

    //1)Here we are scheduling and updating stocks data every 5 seconds (5000 ms)
    //2) Its similar to @Scheduled
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Downloading and updating stocks..Data :: Thread-id :: "+Thread.currentThread().getId());


        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.scheduleAtFixedRate(runnable,1000,5000, TimeUnit.MILLISECONDS);

    }
}
