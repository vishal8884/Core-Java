package ConcorrectCollections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListProblem {

	public static void main(String[] args) {

		ArrayList<Object> courses = new ArrayList<>();
		
		courses.add("java");
		courses.add("pytohn");
		courses.add("AWS");
		courses.add("Docker");
		
		Iterator<Object> iterator = courses.iterator();
		
		while(iterator.hasNext()) {
			System.out.println("iterater next :: "+iterator.next());
			courses.add("node"); //concorunet modification exception occures here as we tried to add after creating a iterator
		}
		
	}

}
