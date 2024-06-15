package concorrency.course2.concurrentCollections;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker implements Runnable {

    private int id;
    private CountDownLatch countDownLatch;

    public Worker(CountDownLatch countDownLatch,int id){
        this.countDownLatch = countDownLatch;
        this.id = id;
    }

    @Override
    public void run() {
        doSomeWork();
        countDownLatch.countDown();
    }

    private void doSomeWork(){
        try {
            System.out.println("Thread :: "+id);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


public class T2_LatchExample {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(int i=0;i<5;i++){
            executorService.execute(new Worker(countDownLatch,i));
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Processing is Done");

    }
}
/*
What is CountDownLatch

1) It will wait for 5 threads to call countDownMethod and then complete the process.


 latch = latch example main Thread (single thread) is waiting for other threads to complete its process
 cyclicBarries -> multipleThread can wait for each other
               -> we can use reset  



Benifits of Count Down latch

1) with join() it will wait for one thread to complete.. in latch it can wait for multiple threads to complete
2)

Questions

1) if I dont give countDown Latch in this example then same thing will happen







 */