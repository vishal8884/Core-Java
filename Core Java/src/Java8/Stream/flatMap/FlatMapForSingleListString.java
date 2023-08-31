package Java8.Stream.flatMap;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FlatMapForSingleListString {

	public static void main(String[] args) {
		Function<String, String> function1 = name -> name.toUpperCase();

		List<String> names = Arrays.asList("vishal","abcd","bell","waters");
		
		List<String> flattenedNames = names.stream().flatMap(name -> splitStr(name).stream()).collect(Collectors.toList());
		System.out.println("flattenedNames :: "+flattenedNames);
		
		List<Character> namesFirstChar = names.stream().sorted().map(name -> name.charAt(0)).collect(Collectors.toList());
		System.out.println("namesFirstChar :: "+namesFirstChar);
	}
	
	
	private static List<String> splitStr(String s) {
		return Arrays.asList(s.split(""));
	}

}
