package concorrency.completableFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import concorrency.completableFuture.dto.Employee;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class T2_RunAsyncDemo {

    public static void main(String[] args) {
        T2_RunAsyncDemo demo = new T2_RunAsyncDemo();
        demo.saveEmployee(new File("employee.json"));
    }


    public void saveEmployee(File employeeFile) {
        ObjectMapper objectMapper = new ObjectMapper();

//        CompletableFuture.runAsync(() -> {
//            try {
//                List<Employee> employees = objectMapper.readValue(employeeFile, new TypeReference<List<Employee>>() {
//                });
//
//                System.out.println("Read employees Printing it..........");
//                employees.forEach(System.out::println);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
    }
}