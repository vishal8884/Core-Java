package Java8.Stream.playAround;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {

	public static void main(String[] args) {

		List<List<String>> names;
		
		List<String> nameList1= Arrays.asList("a1","a2","a3");
		List<String> nameList2= Arrays.asList("b1","b2","b3");
		List<String> nameList3= Arrays.asList("c1","c2","c3");
		
		names = Arrays.asList(nameList1,nameList2,nameList3);
		System.out.println("names :: "+names);
		
		//In flat map for each nameList we are returning its stream .... (in map we are just returning its obj not stream)
		List<String> flattenedNames = names.stream().flatMap(nameList -> nameList.stream()).collect(Collectors.toList());
		System.out.println("flattenedNames :: "+flattenedNames);
		
		
		//Map example
		List<String> namesMapFunc = names.stream().map(nameList -> nameList.get(0).toUpperCase()).collect(Collectors.toList());
		System.out.println("namesMapFunc :: "+namesMapFunc);
	}

}
