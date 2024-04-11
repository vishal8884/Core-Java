package concorrency.course2.multithreadingConcepts;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class T3_AtomicVariables {

    private static final AtomicInteger counter = new AtomicInteger(0); //This takes care of synchronization internally

    public static void main(String[] args) throws InterruptedException {
        T3_AtomicVariables atomicVariables = new T3_AtomicVariables();

        Thread t1 = new Thread(atomicVariables :: increment);
        Thread t2 = new Thread(atomicVariables :: increment);


        t1.start();
        t2.start();


        t1.join();
        t2.join();

        System.out.println("counter :: "+counter);
    }


    public void increment(){
        IntStream.range(0,10000).forEach(elem -> counter.getAndIncrement());
    }
}
