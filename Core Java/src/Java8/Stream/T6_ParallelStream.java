package Java8.Stream;

import java.util.Arrays;

public class T6_ParallelStream {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        // Perform operations in parallel
        Arrays.stream(numbers)
                .parallel()
                .forEach(System.out::println);
    }
}
