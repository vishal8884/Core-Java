package concorrency.course2.interThreadCommunication;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class T6_Locks {
    public static int counter = 0;
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            IntStream.range(0,10000).forEach(elem -> {
                increment();
            });
        });

        Thread t2 = new Thread(() -> {
            IntStream.range(0,10000).forEach(elem -> {
                increment();
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


        System.out.println("counter after increment :: "+counter);
    }

    //its same as synchronized but the benifit is you can release the lock (unlock) in other method also
    private static void increment(){
        lock.lock();
        try{
            counter++;
        } finally {
            lock.unlock();//if any exception then it will be deadlocked thats why
        }

    }
}
