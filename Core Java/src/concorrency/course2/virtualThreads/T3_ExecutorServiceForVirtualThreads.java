package concorrency.course2.virtualThreads;

import java.util.concurrent.Executors;

public class T3_ExecutorServiceForVirtualThreads {
    public static void main(String[] args) {
        Runnable runnable = T1_CreateVirtualThreads.getRunnable();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(runnable);
            executor.submit(runnable);
            executor.submit(runnable);
            executor.submit(runnable);
        }
    }
}
