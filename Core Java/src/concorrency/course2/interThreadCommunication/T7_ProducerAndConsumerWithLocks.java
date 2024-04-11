package concorrency.course2.interThreadCommunication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

class Worker {
    Lock lock = new ReentrantLock(true);
    Condition condition = lock.newCondition();

    public void produce() throws InterruptedException {
        lock.lock(); //Similar to synchornized we use wait() and notify() only for synchronized method
        System.out.println("Produce called");
        condition.await(); //wait()
        System.out.println("Produce done");
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        lock.lock();
        System.out.println("Started Consuming");
        Thread.sleep(1000);
        System.out.println("Done Consuming");
        condition.signal();
        lock.unlock();
    }
}

public class T7_ProducerAndConsumerWithLocks {

    public static void main(String[] args) {
        Worker worker = new Worker();

        Thread t1 = new Thread(() -> {
            IntStream.range(0,10).forEach(elem -> {
                try {
                    worker.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });

        Thread t2 = new Thread(() -> {
            IntStream.range(0,10).forEach(elem -> {
                try {
                    worker.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });


        t1.start();
        t2.start();


        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
