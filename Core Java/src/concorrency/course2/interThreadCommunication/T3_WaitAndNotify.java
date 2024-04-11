package concorrency.course2.interThreadCommunication;

class ConsumerProducerService {

    public void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("Started producing data");
            wait(); //this will wait for consumer to consume and notify
            System.out.println("finished producing data");
        }
    }

    public void consume(){
        synchronized (this){
            System.out.println("Started Consuming data");
            notify(); //after consuming it will notify the producer to continue its job
            System.out.println("finished Consuming data"); //even if notify is called all the below lines will be executed
        }
    }
}


public class T3_WaitAndNotify {
    public static void main(String[] args) {
        ConsumerProducerService consumerProducerService = new ConsumerProducerService();

        Thread t1 = new Thread(() -> {
            try {
                consumerProducerService.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            consumerProducerService.consume();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
