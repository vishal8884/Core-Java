package Collections.List;

import java.util.ArrayList;
import java.util.List;

public class ListMethods {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		
		for(int i= 10;i <= 100;i=i+10) {
			list.add(i);
		}
		
		System.out.println("list :: "+list);
		
		list.add(2,43);  //this inserts in between
		
		System.out.println("list after replacement:: "+list);
		
		list.set(4,444); // this replaces the value
		
		System.out.println("list after replacement 2 :: "+list);
		
		
		List<Integer> secondList = new ArrayList<>();
		
		secondList.add(111);
		secondList.add(222);
		secondList.add(333);
		
		System.out.println("secondlist :: "+secondList);
		
		list.addAll(4, secondList);   //it adds  from the 4 index
		
		System.out.println("list after adding second list :: "+list);
		
		boolean contains = list.contains(222);
		
		System.out.println("contains :: "+contains);
		
		
		list.remove(3);
		
		System.out.println("list after removing index 3 :: "+list);
	}

}
