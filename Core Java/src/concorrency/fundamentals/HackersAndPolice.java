package concorrency.fundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class HackersAndPolice {
    private static final int MAX = 9999;

    public static void main(String[] args) {
        Random random = new Random();
        int password = random.nextInt(MAX);

        List<Thread> threads = new ArrayList<>();

        Thread hackerThreadAsc = new Thread(() -> {
            IntStream.range(0,MAX).forEach(elem -> {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(elem == password){
                    System.out.println("Hacked password :: "+password+" by asc team");
                    System.exit(0);
                }
            });
        });

        Thread hackerThreadDsc = new Thread(() -> {
            for(int i=MAX;i>=0;i--){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(i == password){
                    System.out.println("Hacked password :: "+password+" by dsc team");
                    System.exit(0);
                }
            }
        });

        Thread policeThread = new Thread(() -> {
            IntStream.range(1,11).forEach(elem -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Looking for hackers by police team in :: "+elem);
            });
            System.out.println("Caught you hackers");
            System.exit(0);
        });

        threads.add(hackerThreadAsc);
        threads.add(hackerThreadDsc);
        threads.add(policeThread);

        for(Thread t : threads){
            t.start();
        }
    }
}

