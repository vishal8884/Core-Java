package Java8.Stream;

import playaround.other.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class T2_TypesOfCollectors {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Emily");

        // Collect names starting with 'A' into a new list
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println("Filtered names: " + filteredNames);

        //Grouping By

        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 25),
                new Person("David", 30),
                new Person("Emily", 35)
        );

        // Group people by age
        Map<Integer, List<Person>> peopleByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        // Print people grouped by age
        peopleByAge.forEach((age, persons) -> {
            System.out.println("Age: " + age);
            persons.forEach(person -> System.out.println("  " + person.getName()));
        });
    }
}

/*
• Summing:
	• Collectors.summingInt(), Collectors.summingLong(), Collectors.summingDouble():
		○ These collectors compute the sum of numeric elements in a stream.
		○ Example: int sum = list.stream().collect(Collectors.summingInt(Integer::intValue));
• Averaging:
	• Collectors.averagingInt(), Collectors.averagingLong(), Collectors.averagingDouble():
		○ These collectors compute the average of numeric elements in a stream.
		○ Example: double average = list.stream().collect(Collectors.averagingInt(Integer::intValue));
• Grouping:
	• Collectors.groupingBy():
		○ This collector groups elements of a stream by a classifier function.
		○ Example: Map<Type, List<Item>> groupedItems = list.stream().collect(Collectors.groupingBy(Item::getType));
• Partitioning:
	• Collectors.partitioningBy():
		○ This collector partitions elements of a stream into two groups based on a predicate.
		○ Example: Map<Boolean, List<Item>> partitionedItems = list.stream().collect(Collectors.partitioningBy(Item::isAvailable));
• Counting:
	• Collectors.counting():
		○ This collector counts the number of elements in a stream.
		○ Example: long count = list.stream().collect(Collectors.counting());
• Mapping:
	• Collectors.mapping():
		○ This collector applies a mapping function to each element of a stream before collecting.
		○ Example: List<String> names = list.stream().collect(Collectors.mapping(Item::getName, Collectors.toList()));
• Reducing:
	• Collectors.reducing():
		○ This collector performs a reduction on the elements of a stream using an associative accumulation function.
		○ Example: int sum = list.stream().collect(Collectors.reducing(0, Item::getQuantity, Integer::sum));

 */
