package concorrency.course2.interThreadCommunication;

public class T4_LockingWithCustomObjects {
    public static int counter1 = 0;
    public static int counter2 = 0;
    public static final Object o1 = new Object();
    public static Object o2 = new Object();

    public static void main(String[] args) throws InterruptedException {

        long startTimeMs = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            process();
        }
        long totalTimeMs = System.currentTimeMillis() - startTimeMs;

        System.out.println("counter1 :: "+counter1+"     counter2 :: "+counter2+"    totalTimeMs :: "+totalTimeMs);
    }


    public static void process() throws InterruptedException {
       // Thread.sleep(1000);
        Thread t1 = new Thread(() -> {
            incrementCounter1();
        });


        Thread t2 = new Thread(() -> {
            incrementCounter2();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

       // System.out.println("Finished processing");
    }


    public static void incrementCounter1(){
        synchronized (o1) {
            counter1++;
        }
    }
    public static void incrementCounter2(){
        synchronized (o2) {
            counter2++;
        }
    }
}
