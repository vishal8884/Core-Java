package concorrency.exercises;

import java.util.concurrent.atomic.AtomicInteger;

public class T2_ThreadSyncronization {


    public static void main(String[] args) throws InterruptedException {
        T2_ThreadSyncronization t2ThreadSyncronization = new T2_ThreadSyncronization();
        t2ThreadSyncronization.incrementCounterWithSync();

    }


    public void incrementCounterWithSync() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger();
        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            for(int i=0;i<100000;i++){
                synchronized (lock){ //synchronized not rquired here as actomicInteger is thread safe operation
                    counter.getAndIncrement();
                }
            }
        });


        Thread t2 = new Thread(() -> {
            for(int i=0;i<100000;i++){
                synchronized (lock){
                    counter.getAndIncrement();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.get());
    }
}



/*

Thread Synchronization with Locks
Objective: Learn how to avoid race conditions using locks.

Write a program with two threads that each increment a shared counter 1000 times. Without synchronization, this will lead to a race condition, and the counter will not correctly reflect the number of increments.
Fix the race condition using a lock or mutex to ensure only one thread updates the counter at a time.
 */
