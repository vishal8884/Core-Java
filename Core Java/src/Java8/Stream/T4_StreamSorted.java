package Java8.Stream;

import java.util.Arrays;
import java.util.List;

public class T4_StreamSorted {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Emily");

        // Sort names alphabetically
        names.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
