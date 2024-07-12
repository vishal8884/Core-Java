package Java8.Stream;

import java.util.Arrays;
import java.util.List;

public class T5_Reduce_OrSum {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Reduce to calculate sum of numbers
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Sum: " + sum);
    }
}
