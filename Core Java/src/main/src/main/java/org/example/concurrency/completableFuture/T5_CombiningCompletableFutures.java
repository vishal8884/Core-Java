package org.example.concurrency.completableFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.concurrency.completableFuture.dto.Employee;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class T5_CombiningCompletableFutures {

    //1) Combining dependent futures
    //2) Combining independent futures
    //3) combining multiple futures
    //4) Combining multiple futures (no need to wait for All)
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1) Combining dependent futures
        T5_CombiningCompletableFutures t5CombiningCompletableFutures = new T5_CombiningCompletableFutures();
        t5CombiningCompletableFutures.combineDependentFuture();

        //2) Combine 2 independent future
        t5CombiningCompletableFutures.combineIndependentFutures();

    }

    public void combineIndependentFutures() throws ExecutionException, InterruptedException {
        //First Thread will fetch the male and female employees count
        CompletableFuture<Map<String, Long>> genderCountFuture = CompletableFuture.supplyAsync(() -> getEmployessFromDb().stream().collect(Collectors.groupingBy(e -> e.getGender(), Collectors.counting())));

        //Second Thread will fetch the email Id of employees
        CompletableFuture<List<String>> emailIdsFuture = CompletableFuture.supplyAsync(() -> getEmployessFromDb().stream().map(Employee::getEmail).toList());

        CompletableFuture<String> result = genderCountFuture.thenCombine(emailIdsFuture, (gender, email) -> gender + "  " + email);
        String res = result.get();

        System.out.println(res);
    }

    public void combineDependentFuture(){
        //First Thread will get the required employee
        //Second Thread will get the above employeeRatings
        String employeeEmail = "jbraybrooke6@prnewswire.com";


        Supplier<Employee> fetchValidEmployee = () -> {
            System.out.println("Getting Employess from DB :: "+Thread.currentThread().getName());
            List<Employee> employess = getEmployessFromDb();
            return employess.stream()
                    .filter(e -> e.getEmail().equals(employeeEmail)).findFirst().orElse(null);
        };

        Function<Employee,CompletableFuture<Integer>> function = employee -> {
            System.out.println("Getting Employess from DB :: "+Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> employee.getRating()+2);
        };

        CompletableFuture<Integer> futureForRating = CompletableFuture.supplyAsync(fetchValidEmployee)
                .thenCompose(function);

        try {
            Integer rating = futureForRating.get();
            System.out.println("rating :: "+rating);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }


    //*****************************************************Utils**********************************************************************************************


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
