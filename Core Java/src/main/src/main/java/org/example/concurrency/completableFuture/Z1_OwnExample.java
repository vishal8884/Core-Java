package org.example.concurrency.completableFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.concurrency.completableFuture.dto.Employee;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Z1_OwnExample {

    public static void main(String[] args) {

        Z1_OwnExample z1OwnExample = new Z1_OwnExample();
        List<Employee> employees = z1OwnExample.updateEmployeeRatingBasedOnNameParallel();
        employees.stream().filter(e -> e.getFirstName().equals("Axe")).forEach(System.out::println);
    }


    public List<Employee> updateEmployeeRatingBasedOnNameParallel(){
        List<Employee> employess = getEmployessFromDb();
        employess.stream().filter(e -> e.getFirstName().equals("Axe")).forEach(e -> System.out.println("before :: "+e));
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for(Employee employee : employess){
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                int updatedRating = getUpdatedRatingBasedOnName(employee.getFirstName(), employee.getRating());
                System.out.println("Thread Name :: "+Thread.currentThread().getName()+"     Employee Name :: "+employee.getFirstName());
                employee.setRating(updatedRating);
            });

            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        return employess;
    }


    public List<Employee> updateEmployeeRatingBasedOnName(){
        List<Employee> employess = getEmployessFromDb();
        employess.stream().filter(e -> e.getFirstName().equals("Axe")).forEach(e -> System.out.println("before :: "+e));

        for(Employee employee : employess){
            int updatedRating = getUpdatedRatingBasedOnName(employee.getFirstName(),employee.getRating());
            employee.setRating(updatedRating);
        }

        return employess;
    }


    public int getUpdatedRatingBasedOnName(String name,int rating){
        Map<String, Integer> ratingsMap = getRatingsMap();

        if(ratingsMap.containsKey(name))
            return ratingsMap.get(name);

        return rating;
    }

    private static Map<String, Integer> getRatingsMap() {
        Map<String,Integer> ratingsMap = new HashMap<>();
        ratingsMap.put("Axe",10);
        ratingsMap.put("Jenda",8);
        ratingsMap.put("Jannel",10);
        ratingsMap.put("Marris",8);
        ratingsMap.put("Lorin",10);
        return ratingsMap;
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
}
