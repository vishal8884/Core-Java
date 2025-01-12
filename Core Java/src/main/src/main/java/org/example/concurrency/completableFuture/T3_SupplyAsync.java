package org.example.concurrency.completableFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.concurrency.completableFuture.dto.Employee;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class T3_SupplyAsync {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        File file = new File("B:\\Software Engineering\\Github Projects\\core java\\Core-Java\\Core Java\\src\\main\\src\\main\\resources\\employes.json");

        T3_SupplyAsync t3SupplyAsync = new T3_SupplyAsync();
        t3SupplyAsync.fetchEmployeesFromFile(file);
    }


    public void fetchEmployeesFromFile(File employeeFile) throws ExecutionException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();

        CompletableFuture<List<Employee>> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(20);
                System.out.println("Fetching and savinf employees :: "+Thread.currentThread().getName());
                return objectMapper.readValue(employeeFile, new TypeReference<>() {
                });
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Other parallel task in main thread :: "+Thread.currentThread().getName());

        List<Employee> employees = completableFuture.get();

        employees.stream().limit(10).forEach(System.out::println);
    }
}
