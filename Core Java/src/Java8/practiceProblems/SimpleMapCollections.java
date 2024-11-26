package Java8.practiceProblems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SimpleMapCollections {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        //create a map where key is integer and value is square of it

        Map<Integer, Integer> numberSquareMap = numbers.stream()
                .collect(Collectors.toMap(e -> e, //key
                        e -> e * e, //value
                        (existing,replacement) -> replacement, //in case of same key what to do ie additional
                        TreeMap::new)); //ie - additional
        System.out.println(numberSquareMap);
    }
}
