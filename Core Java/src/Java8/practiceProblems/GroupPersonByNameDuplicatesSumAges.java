package Java8.practiceProblems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupPersonByNameDuplicatesSumAges {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Alice", 35),
                new Person("Charlie", 40)
        );

        //group by name and sum if 2 people have same name
        Map<String, Integer> map = personList.stream().collect(Collectors.groupingBy(
                e -> e.getName(), //group as list for common name of person
                Collectors.summingInt(e -> e.getAge())
        ));

        System.out.println(map);
        
        //group by age

        Map<Integer, List<Person>> ageMap = personList.stream().collect(Collectors.groupingBy(e -> e.getAge()));
        System.out.println(ageMap);

        //key = name  and value = age *2

        Map<String, Integer> modifiedAgeMap = personList.stream().collect(Collectors.toMap(
                e -> e.getName(),
                e -> e.getAge() * 2,
                (a,b) -> a
        ));
        System.out.println(modifiedAgeMap);
    }
}
