package concorrency.course2.exercises.DiningPhilosophers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {

    private int id;
    private Lock lock;

    public ChopStick(int id){
        this.id = id;
        this.lock = new ReentrantLock();
    }


    public boolean pickup(Philosopher philosopher,State state) throws InterruptedException {
        if(this.lock.tryLock(10, TimeUnit.MILLISECONDS)){
            System.out.println(philosopher+" got lock on "+state+" "+this);
            return true;
        }
        else{
            System.out.println(philosopher+" could not get lock on "+state+" "+this);
            return false;
        }
    }

    public void putDown(Philosopher philosopher,State state){
        this.lock.unlock();
        System.out.println(philosopher+" put down "+state+" "+this);
    }


    @Override
    public String toString() {
        return "ChopStick "+id;
    }


}
