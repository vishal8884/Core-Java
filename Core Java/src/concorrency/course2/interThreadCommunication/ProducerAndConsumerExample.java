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
    public List<Double> list = new ArrayList<>();
    public Object o1 = new Object();

    public void producer(){
        synchronized (list){
            for(int i=lowerLimit;i<=upperLimit;i++){
                System.out.println("adding elem ::"+i+"     list :: "+list);
                list.add((double) i);
            }
        }
    }

    public void consumer(){
        synchronized (list){
            for(int i=lowerLimit;i<=upperLimit;i++){
                System.out.println("removing elem :: "+i+"      list :: "+list);
                list.remove((double) i);
            }
        }
    }

    public void printList(){
        System.out.println(list);
    }
}


public class ProducerAndConsumerExample {
    private static final int LOWER_LIMIT = 1;
    private static final int HIGHER_LIMIT = 5;

    public static void main(String[] args) throws InterruptedException {
        Processor processor = new Processor(LOWER_LIMIT,HIGHER_LIMIT);

        Thread t1 = new Thread(() -> processor.producer());
        Thread t2 = new Thread(() -> processor.consumer());


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        processor.printList();
    }


}
