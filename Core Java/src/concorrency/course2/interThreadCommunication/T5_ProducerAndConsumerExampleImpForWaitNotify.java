package concorrency.course2.interThreadCommunication;

import java.util.ArrayList;
import java.util.List;

class Processor {
    int lowerLimit;
    int upperLimit;

    public Processor(int lowerLimit,int upperLimit){
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }
    public final List<Double> list = new ArrayList<>();
    public Object o1 = new Object();
    public int value = 0;

    public void producer() throws InterruptedException {
        synchronized (list){
            while(true){
                if(list.size() == upperLimit){
                    System.out.println("added till upper limit");
                    list.wait(); //its going to notify removing thread to go ahead with its procees
                    // as lines of code run even after notify() is called untill this wait() is called above thread is not notified (this is like a break_
                }
                else{
                    System.out.println("adding value :: "+value);
                    list.add((double) value);
                    value++;
                    list.notify(); //this notify will not work until this method finishs or wait() is called
                }
                Thread.sleep(1000);
            }
        }
    }

    public void consumer() throws InterruptedException {
        synchronized (list){
            while(true){
                if(list.size() == lowerLimit){
                    System.out.println("removed all till lowerLimit");
                    list.wait();     //it goinf to notify adding thread to go ahead with its procees
                                     // as lines of code run even after notify() is called untill this wait() is called above thread is not notified (this is like a break_
                }
                else{
                    System.out.println("removing value "+list.get(list.size()-1));
                    list.remove(list.size()-1);
                    list.notify(); //this notify will not work until this method finishs or wait() is called
                    //notify says my tasks is completed you can resume your tasks who ever is wating
                    //This notify is mainly to notify above thread 1 wait()
                }
                Thread.sleep(1000);
            }
        }
    }

    public void printList(){
        System.out.println(list);
    }
}


public class T5_ProducerAndConsumerExampleImpForWaitNotify {
    private static final int LOWER_LIMIT = 1;
    private static final int HIGHER_LIMIT = 5;

    public static void main(String[] args) throws InterruptedException {
        Processor processor = new Processor(LOWER_LIMIT,HIGHER_LIMIT);

        Thread t1 = new Thread(() -> {
            try {
                processor.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                processor.consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        processor.printList();
    }
}
