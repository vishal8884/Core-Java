package concorrency.course2.concurrentCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T1_ListExample {
    public static void main(String[] args) {

        //<String> list = new ArrayList<>();
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        //Not effecient
        //1) This will synchronize but it will not do the process in parallel (Threads have to wait for each other to execute independent operations)
        //2) under the hood java will use

        //Concorrent collections in optimal for this case

        Thread t1 = new Thread(() -> {
            for(int i=0;i<1000;i++){
                list.add("elem"+i);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0;i<1000;i++){
                list.add("elem"+i);
            }
        });

        t1.start();
        t2.start();


        try{
            t1.join();
            t2.join();
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(list.size());
    }
}
