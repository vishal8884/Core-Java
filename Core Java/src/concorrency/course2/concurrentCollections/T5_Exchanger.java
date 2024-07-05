package concorrency.course2.concurrentCollections;


import java.util.concurrent.Exchanger;

class IncrementerThread implements Runnable {

    private Integer counter;
    private Exchanger<Integer> exchanger;

    public IncrementerThread(Integer counter,Exchanger<Integer> exchanger){
        this.counter = counter;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while(true){
            counter++;
            try {
                counter = exchanger.exchange(counter);

                System.out.println("counter in incrementer thread :: "+counter);

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class DecrementerThread implements Runnable {

    private Integer counter;
    private Exchanger<Integer> exchanger;

    public DecrementerThread(Integer counter,Exchanger<Integer> exchanger){
        this.counter = counter;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while(true){
            counter--;
            try {
                counter = exchanger.exchange(counter);

                System.out.println("counter in decrementer thread :: "+counter);

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


public class T5_Exchanger {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();

        new Thread(new IncrementerThread(0,exchanger)).start();
        new Thread(new DecrementerThread(0,exchanger)).start();
    }
}
