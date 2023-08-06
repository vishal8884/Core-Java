package Java8.Stream;

import java.util.stream.Stream;

public class StreamIterate {

	public static void main(String[] args) {

		Stream.iterate(1, e -> e+1).filter(e -> e%2 ==0).limit(10).forEach(System.out::println);
		System.out.println();
		
	}

}
