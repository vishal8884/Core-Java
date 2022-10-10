package ConcorrectCollections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListProblemSolved {

	public static void main(String[] args) {

		CopyOnWriteArrayList<Object> courses = new CopyOnWriteArrayList();
		
		courses.add("java");
		courses.add("pytohn");
		courses.add("AWS");
		courses.add("Docker");
		
		Iterator<Object> iterator = courses.iterator();
		
		while(iterator.hasNext()) {
			System.out.println("iterater next :: "+iterator.next());
			courses.add(Math.random()); //concorunet modification exception occures here as we tried to add after creating a iterator
		}
		
		
		System.out.println("courses at end :: "+courses);
		
	}

}
