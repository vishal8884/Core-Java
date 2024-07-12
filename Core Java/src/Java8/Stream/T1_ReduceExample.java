package Java8.Stream;

import java.util.Arrays;
import java.util.List;

public class T1_ReduceExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // Custom reduction to find the maximum number
        int max = numbers.stream()
                .reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        System.out.println("Maximum number: " + max);

        //Example 2-------------------------------------------------------------------------------------------------

        List<String> words = Arrays.asList("Java", "is", "awesome");
        // Concatenate all strings
        String concatenated = words.stream()
                .reduce("", (a, b) -> a + " " + b);
        System.out.println("Concatenated string: " + concatenated);
    }
}
