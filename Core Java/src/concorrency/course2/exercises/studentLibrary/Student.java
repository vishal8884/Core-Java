package concorrency.course2.exercises.studentLibrary;

import java.util.Arrays;
import java.util.Random;

public class Student implements Runnable{

    private int id;
    private Book[] books;
    private Random random;

    public Student(int id,Book[] books){
        this.id = id;
        this.books = books;
        random = new Random();
    }

    @Override
    public void run() {
        while(true){
            int bookId = random.nextInt(Constants.NUMBER_OF_BOOKS);
            Book book = books[bookId];

            try {
                book.read(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public String toString() {
        return "Student # "+id;
    }
}
