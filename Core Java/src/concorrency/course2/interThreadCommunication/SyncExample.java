package concorrency.course2.interThreadCommunication;

import java.util.stream.IntStream;

public class SyncExample {
    static int counter = 0;
    private static final Object o = new Object();

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<1000000;i++){
            process();
            System.out.println("final counter :: "+ counter+"     i :: "+i);
            if(counter != 200){
                System.out.println("counter is not 200 for i :: "+i+"    counter :: "+counter);
                break;
            }

            counter = 0;
        }
    }


    public static void process() {
        Thread t1 = new Thread(() -> {
            for(int i=1;i<=100;i++){
                increment();
            }
           // System.out.println("thread1 counter :: "+ counter);
        });

        //Thread.sleep(10000);

        Thread t2 = new Thread(() -> {
            for(int i=1;i<=100;i++){
                increment();
            }
           // System.out.println("thread2 counter :: "+ counter);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //if we make this method or block sync then we will not face this issue
    //but it will cause class level lock
    //so we create a object and lock it
    private static synchronized void increment() {
        counter++;
    }

}
