package concorrency.course2.virtualThreads;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T2_PlatformVsVirtualThreads {
    public static void main(String[] args) {
//        platformThread();
        virtualThread();
        System.out.println("Process Completed");
    }

   //At Some point of time due to so many threads we get outofMemoryException
    private static void platformThread(){
        for(int i=0;i<10000000;i++){
            Thread.ofPlatform().start(() -> {
                System.out.println("starting thread :: "+Thread.currentThread().getName());
                try {
                    Thread.sleep(Duration.ofSeconds(5));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Finshed thread :: "+Thread.currentThread().getName());
            });
        }
    }

    //Here We do not get out Of Memory Exception due to virtual Threads
    private static void virtualThread(){
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

        for(int i=0;i<10000000;i++){
            executorService.submit(() -> {
                System.out.println("starting thread :: "+Thread.currentThread().getName());
                try {
                    Thread.sleep(Duration.ofSeconds(5));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Finshed thread :: "+Thread.currentThread().getName());
            });
        }
    }
}
