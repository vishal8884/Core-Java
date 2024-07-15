package concorrency.course2.exercises.studentLibrary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppRunner {
    public static void main(String[] args) {

        Book[] books = null;
        Student[] students = null;
        ExecutorService executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_STUDENTS);

        try {
            //init all
            books = new Book[Constants.NUMBER_OF_BOOKS];
            students = new Student[Constants.NUMBER_OF_STUDENTS];

            //init books
            for(int i=0;i<Constants.NUMBER_OF_BOOKS;i++){
                books[i] = new Book(i+1);
            }

            //init Students and start thread
            for(int i=0;i<Constants.NUMBER_OF_STUDENTS;i++){
                students[i] = new Student(i+1,books);
                executorService.execute(students[i]);
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
