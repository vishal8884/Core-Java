package concorrency.course2.multithreadingConcepts;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader {
    INSTANCE;

    private Semaphore semaphore = new Semaphore(3,true);
    //At a given point of time 3 Threads can access this download method..others will have to wait

    public void download(){
        try {
            semaphore.acquire();
            downloader();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    private void downloader(){
        System.out.println("Downloading............. by Thread :: "+Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Downloaded............. by Thread :: "+Thread.currentThread().getName());
    }
}

public class T3_Semaphores {

    public static void main(String[] args) {
//        List<Thread> list = new ArrayList<>();
//
//        for(int i=0;i<10;i++){
//            list.add(new Thread(() -> Downloader.INSTANCE.download()));
//        }
//
//        for(Thread t : list){
//            t.start();
//        }

        ExecutorService es = Executors.newCachedThreadPool();

        for(int i=0;i<12;i++){
            es.execute(() -> Downloader.INSTANCE.download());
        }
    }

}
