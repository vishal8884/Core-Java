package Collections.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

	public static void main(String[] args) {

		Object objects[] = new Object[1000000];
		
		for(int i=0;i<objects.length;i++) {
			objects[i] = new Object();
		}
		
		LinkedList<Object> list = new LinkedList<>();
		long start = System.currentTimeMillis();
		for(Object object : objects) {
			list.add(object);
		}
		long end = System.currentTimeMillis();
		System.out.println("time taken by linked list :: "+(end-start));
		
		
		List<Object> list2 = new ArrayList<>();
		long start2 = System.currentTimeMillis();
		for(Object object : objects) {
			list2.add(object);
		}
		long end2 = System.currentTimeMillis();
		System.out.println("time taken by array list :: "+(end2-start2));
		
	}

}
