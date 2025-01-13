package org.example.concurrency.completableFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.concurrency.completableFuture.dto.Employee;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class T4_ThenApplyAcceptRunDemo {
    /*
    1) Get All Employess from DB
    2) Filter out new joined employees
    3) Check if training activity is pending
    4) get employees email id
    5) Send remainder notification to employees
     */


    public static void main(String[] args) {
        T4_ThenApplyAcceptRunDemo t4ThenApplyAcceptRunDemo = new T4_ThenApplyAcceptRunDemo();
        t4ThenApplyAcceptRunDemo.sendRemainderForNewEmployeeNotCompletedTrainingAsync();
    }

    //**********************Async completable future*****************************************//

    private void sendRemainderForNewEmployeeNotCompletedTrainingAsync(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
                    return getEmployessFromDb();
                },executorService).thenApplyAsync(emp -> {
                    System.out.println("Filtering out the Employees who is new :: " + Thread.currentThread().getName());
                    return emp.stream().filter(e -> null != e && "TRUE".equals(e.getNewJoiner())).collect(Collectors.toList());
                },executorService)
                .thenApplyAsync(emp -> {
                    System.out.println("Filtering out the new employees whose learning is pending :: " + Thread.currentThread().getName());
                    return emp.stream().filter(e -> null != e && "TRUE".equals(e.getLearningPending())).toList();
                },executorService)
                .thenApplyAsync(emp -> {
                    System.out.println("geting the email and sending notification :: " + Thread.currentThread().getName());
                    return emp.stream().map(e -> e.getEmail()).toList();
                },executorService)
                .thenAcceptAsync(emailIdList -> {
                    System.out.println("Sending Email notification :: " + Thread.currentThread().getName());
                    sendEmailNotification(emailIdList);
                });

        System.out.println("Running other tasks parallely :: "+Thread.currentThread().getName());

        try {
            completableFuture.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }


    //**********************Sync completable future ****************************************//

    private void sendRemainderForNewEmployeeNotCompletedTraining(){

        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
                    return getEmployessFromDb();
                }).thenApply(emp -> {
                    System.out.println("Filtering out the Employees who is new :: " + Thread.currentThread().getName());
                    return emp.stream().filter(e -> null != e && "TRUE".equals(e.getNewJoiner())).collect(Collectors.toList());
                })
                .thenApply(emp -> {
                    System.out.println("Filtering out the new employees whose learning is pending :: " + Thread.currentThread().getName());
                    return emp.stream().filter(e -> null != e && "TRUE".equals(e.getLearningPending())).toList();
                })
                .thenApply(emp -> {
                    System.out.println("geting the email and sending notification :: " + Thread.currentThread().getName());
                    return emp.stream().map(e -> e.getEmail()).toList();
                })
                .thenAccept(emailIdList -> {
                    System.out.println("Sending Email notification :: " + Thread.currentThread().getName());
                    sendEmailNotification(emailIdList);
                });

        System.out.println("Running other tasks parallely :: "+Thread.currentThread().getName());

        try {
            completableFuture.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }


    //*****************************************************Utils**********************************************************************************************

    private void sendEmailNotification(String emailId){
        System.out.println("Sent Email notification for :: "+emailId);
    }

    private void sendEmailNotification(List<String> emailId){
        System.out.println("Sent Email notification for :: "+emailId);
    }

    private static List<Employee> getEmployessFromDb(){
        ObjectMapper objectMapper = new ObjectMapper();
        File employeeFile = new File("B:\\Software Engineering\\Github Projects\\core java\\Core-Java\\Core Java\\src\\main\\src\\main\\resources\\employes.json");

        try {
            return objectMapper.readValue(employeeFile, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    private void sendRemainderForNewEmployeeNotCompletedTrainingWithoutCompletableFuture(){
        List<Employee> employess = getEmployessFromDb();

        employess.stream()
                .filter(emp -> null != emp && "TRUE".equals(emp.getNewJoiner()))
                .filter(emp -> null != emp && "TRUE".equals(emp.getLearningPending()))
                .map(Employee::getEmail)
                .forEach(emailId -> sendEmailNotification(emailId));
    }
}
