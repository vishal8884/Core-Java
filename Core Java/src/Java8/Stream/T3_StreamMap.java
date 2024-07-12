package Java8.Stream;

import java.util.Arrays;
import java.util.List;

public class T3_StreamMap {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Emily");

        // Map names to their lengths
        names.stream()
                .map(String::length)
                .forEach(System.out::println);
    }
}
