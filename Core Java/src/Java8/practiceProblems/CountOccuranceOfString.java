package Java8.practiceProblems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOccuranceOfString {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        Map<String, Long> groupedMap = words.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(groupedMap);
    }
}
