package org.example.concurrency.completableFuture;

import javax.naming.CompositeName;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class T8_ExceptionallyDemo {

    //Thread1 gets employee Info
    //Thread2 gets student info

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        T8_ExceptionallyDemo demo = new T8_ExceptionallyDemo();
        demo.GetEmployeeAndStudentInfo();
    }


    public void GetEmployeeAndStudentInfo() throws ExecutionException, InterruptedException {
        CompletableFuture<String> employeeFuture = CompletableFuture.supplyAsync(() -> {
            gracefullyShutDown();
            delay(TimeUnit.SECONDS);
            return "Employee data fetched from Database";
        }).exceptionally(exception -> "Exception occurred so cannot proceed with this thread"+exception.getMessage());

        CompletableFuture<String> studentFuture = CompletableFuture.supplyAsync(() -> {
            delay(TimeUnit.SECONDS);
            return "Student data Fetched from Database";
        });

        String combined = studentFuture.thenCombine(employeeFuture, (stu, emp) -> stu + "        " + emp).get();
        System.out.println(combined);
    }


    //*************************Privat utils ************************************************

    private static void gracefullyShutDown(){
        throw new RuntimeException("Custom Exception for Test");
    }


    private static void delay(TimeUnit timeUnit) {
        try {
            Random r = new Random();
            int num = r.nextInt(1, 3);
            timeUnit.sleep(num);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
