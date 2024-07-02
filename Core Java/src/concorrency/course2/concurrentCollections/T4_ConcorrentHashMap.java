package concorrency.course2.concurrentCollections;

import java.util.concurrent.ConcurrentHashMap;

class UpdateWorker implements Runnable{
    private ConcurrentHashMap<String,Integer> concurrentHashMap;

    public UpdateWorker(ConcurrentHashMap<String,Integer> concurrentHashMap){
        this.concurrentHashMap = concurrentHashMap;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            concurrentHashMap.put("A",12);
            concurrentHashMap.put("X",8);
            Thread.sleep(2000);
            concurrentHashMap.put("C",2);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}


class ReadWorker implements Runnable{
    private ConcurrentHashMap<String,Integer> concurrentHashMap;

    public ReadWorker(ConcurrentHashMap<String,Integer> concurrentHashMap){
        this.concurrentHashMap = concurrentHashMap;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            Integer res1 =concurrentHashMap.get("A");
            System.out.println("res :: "+res1);
            Thread.sleep(1000);
            Integer res2 = concurrentHashMap.get("X");
            System.out.println("res2 :: "+res2);
            Integer res3 =concurrentHashMap.get("C");
            System.out.println("res3 :: "+res3);
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class T4_ConcorrentHashMap {
    public static void main(String[] args) {

        ConcurrentHashMap<String,Integer> concurrentHashMap = new ConcurrentHashMap<>();

        new Thread(new UpdateWorker(concurrentHashMap)).start();
        new Thread(new ReadWorker(concurrentHashMap)).start();
    }
}
