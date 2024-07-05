package concorrency.course2.concurrentCollections;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

class WriterThread1 implements Runnable {
    List<Integer> list;
    public WriterThread1(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Random random = new Random();
            list.set(random.nextInt(list.size()),random.nextInt(10));
        }
    }
}

class WriterThread2 implements Runnable {
    List<Integer> list;
    public WriterThread2(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Random random = new Random();
            list.set(random.nextInt(list.size()),random.nextInt(10));
        }
    }
}


class WriterThread3 implements Runnable {
    List<Integer> list;
    public WriterThread3(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Random random = new Random();
            list.set(random.nextInt(list.size()),random.nextInt(10));
        }
    }
}

class ReaderThread implements Runnable {

    List<Integer> list;
    public ReaderThread(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run() {
        while(true){
            System.out.println(list);
        }
    }
}

public class T6_CopyOnWriteArrays {

    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        new Thread(new WriterThread1(list)).start();
        new Thread(new WriterThread2(list)).start();
        new Thread(new WriterThread3(list)).start();
        new Thread(new ReaderThread(list)).start();
    }
}
