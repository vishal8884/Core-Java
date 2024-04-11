package concorrency.course2.multithreadingConcepts;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T2_DeadLock {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        T2_DeadLock deadLock = new T2_DeadLock();

        Thread t1 = new Thread(deadLock::worker1);
        Thread t2 = new Thread(deadLock::worker2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void worker1(){
        lock1.lock();
        System.out.println("lock1 acquired by worker1");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

       // System.out.println("Worker1 -> Acquiring Lock2");
        lock2.lock();

        lock1.unlock();
        lock2.unlock();

       // System.out.println("Worker1 -> Unlocked lock1 and lock2");
    }

    //To resolve dead-lock worker1 and worker2 needs to lock in same order
    public void worker2(){
        lock2.lock();
        System.out.println("lock2 acquired by worker2");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

       // System.out.println("Worker2 -> Acquiring Lock1");
        lock1.lock();

        lock1.unlock();
        lock2.unlock();

        //System.out.println("Worker2 -> Unlocked lock1 and lock2");
    }
}
