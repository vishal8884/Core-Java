package concorrency.exercises;

public class T1_BasicThreads {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("Hello from Thread T1 :: "+Thread.currentThread().getName()));
        Thread t2 = new Thread(() -> System.out.println("Hello from Thread T2 :: "+Thread.currentThread().getName()));

        t1.start();
        t2.start();
    }



}
