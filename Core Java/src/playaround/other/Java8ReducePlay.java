package playaround.other;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8ReducePlay {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("a1", "a2", "a3", "a4");

        String combinedString = names.stream()
                .collect(Collectors.joining(""));
        System.out.println("combinedString :: "+combinedString);  // Output: a1, a2, a3, a4

        String reduced = names.stream().reduce("", (a, b) -> a + b);
        System.out.println("reduced :: "+reduced);
    }
}
