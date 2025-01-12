package org.example.concurrency.completableFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.concurrency.completableFuture.dto.Employee;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class T2_RunAsyncDemo {

    public static void main(String[] args) {
        T2_RunAsyncDemo demo = new T2_RunAsyncDemo();
        File file = new File("B:\\Software Engineering\\Github Projects\\core java\\Core-Java\\Core Java\\src\\main\\src\\main\\resources\\employes.json");

        demo.saveEmployee(file);
        demo.saveEmployeeCustomExecutor(file);
    }


    public void saveEmployee(File employeeFile) {
        ObjectMapper objectMapper = new ObjectMapper();

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                List<Employee> employees = objectMapper.readValue(employeeFile, new TypeReference<>() {
                });

                System.out.println("Read employees Printing it..........:: "+Thread.currentThread().getName());
                List<Employee> sortedEmp = sortEmployess(employees);
               // sortedEmp.forEach(System.out::println);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Paralelly doing other tasks here");

        try {
            future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }


    public void saveEmployeeCustomExecutor(File employeeFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                List<Employee> employees = objectMapper.readValue(employeeFile, new TypeReference<List<Employee>>() {
                });

                System.out.println("Read employees Printing it..........:: "+Thread.currentThread().getName());
              //  List<Employee> sortedEmp = sortEmployess(employees);
            //    sortedEmp.forEach(System.out::println);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        },executorService);

        try {
            future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Employee> sortEmployess(List<Employee> employees) {
        List<Employee> sortedEmp = employees.stream()
                .sorted(Comparator.comparing(Employee ::getSalary, Comparator.reverseOrder()).thenComparing(Employee ::getFirstName))
                .collect(Collectors.toList());
        return sortedEmp;
    }

}