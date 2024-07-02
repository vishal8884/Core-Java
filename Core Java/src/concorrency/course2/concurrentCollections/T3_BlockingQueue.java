package concorrency.course2.concurrentCollections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

class ProducerWorker implements Runnable{
    private BlockingQueue<Integer> blockingQueue;

    public ProducerWorker(BlockingQueue<Integer> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int counter = 0;

        try{
            for(int i=0;i<1000;i++){
                blockingQueue.add(counter);
                System.out.println("blocking queue inserted with count :: "+counter);
                counter++;
                Thread.sleep(100);
            }
        } catch (InterruptedException e){
            System.out.println("Exception  "+e);
        }
    }
}


class ConsumerWorker implements Runnable{
    private BlockingQueue<Integer> blockingQueue;

    public ConsumerWorker(BlockingQueue<Integer> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try{
            for(int i=0;i<1000;i++){
                Integer counter = blockingQueue.take();
                System.out.println("elem taken from blocking queue :: "+counter);
                Thread.sleep(300);
            }
        } catch (InterruptedException e){
            System.out.println("Exception  "+e);
        }
    }
}



public class T3_BlockingQueue {

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

        ProducerWorker producerWorker = new ProducerWorker(blockingQueue);
        ConsumerWorker consumerWorker = new ConsumerWorker(blockingQueue);

        Thread producerThread = new Thread(producerWorker);
        Thread consumerThread = new Thread(consumerWorker);

        producerThread.start();
        consumerThread.start();
    }
}
