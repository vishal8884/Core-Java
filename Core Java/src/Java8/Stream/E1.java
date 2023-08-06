package Java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;

public class E1 {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("A1","A2","A3","Vishal","Abcd","zxd");
		System.out.println("names before stream = "+names);
		
		anyMatchTest(names);
		
	}

	private static void anyMatchTest(List<String> names) {
		Predicate<String> predicate1 = new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return t.startsWith("B");
			}
		};
		
		boolean anyMatch = names.stream().anyMatch((ip) -> ip.startsWith("A1"));
		System.out.println("Anymatch :: "+anyMatch);
	}

}
