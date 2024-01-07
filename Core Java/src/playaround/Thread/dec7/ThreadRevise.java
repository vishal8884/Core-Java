package playaround.Thread.dec7;

import java.util.stream.IntStream;

public class ThreadRevise {
    public static void main(String[] args) {

        Thread t1 = new Thread(getRunnable());

        System.out.println("starting thread 1");
        t1.start();
        System.out.println("Started thread 1");
    }


    private static Runnable getRunnable(){
        return () -> {
            IntStream.range(0,10).forEach(elem -> {
                long diff = System.currentTimeMillis();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                long diff2 = System.currentTimeMillis() - diff;
                System.out.println("time :: "+diff2+"       elem :: "+elem);
            });
        };
    }
}
