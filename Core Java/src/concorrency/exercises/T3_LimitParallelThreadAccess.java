package concorrency.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class T3_LimitParallelThreadAccess {

    public static final Semaphore semaphore = new Semaphore(4);

    public static void main(String[] args) {
        T3_LimitParallelThreadAccess t3LimitParallelThreadAccess = new T3_LimitParallelThreadAccess();
        t3LimitParallelThreadAccess.connectToDbParallely(20,5);
    }


    public void connectToDbParallely(int n,int maxPermit){
        List<Thread> threads = new ArrayList<>();

        for(int i=1;i<=n;i++){
            Thread thread = new Thread(dbRunnabel(i,maxPermit));
            threads.add(thread);
        }

        //start all threads
        threads.forEach(t -> t.start());

        //join all threads
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }


    private Runnable dbRunnabel(int n,int maxPermit){

        return () -> {
            try {
                semaphore.acquire();
                connectToDatabase(n);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                semaphore.release();
            }
        };
    }


    private void connectToDatabase(int thread){
        System.out.println("SuccessfulltConnected to databse :: "+thread);
    }
}
