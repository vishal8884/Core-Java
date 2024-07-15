package concorrency.course2.exercises.studentLibrary;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {

    private int id;
    private Lock lock;

    public Book(int id){
        this.id = id;
        this.lock = new ReentrantLock();
    }


    public void read(Student student) throws InterruptedException {
        // In This approach Student will wait for 10 seconds to get this book else it will try to get some other book
        if(lock.tryLock(10, TimeUnit.MINUTES)){
            System.out.println(student+" is reading "+this);

            Thread.sleep(2000);

            lock.unlock();
            System.out.println(student+"  finished reading "+this);
        }
//        In below approach Student will wait until this book lock is released by other student
//
//        lock.lock();
//        System.out.println(student+" is reading "+this);
//        Thread.sleep(2000);
//        lock.unlock();
//        System.out.println(student+"  finished reading "+this);

    }

    @Override
    public String toString() {
        return "Book "+id;
    }
}
