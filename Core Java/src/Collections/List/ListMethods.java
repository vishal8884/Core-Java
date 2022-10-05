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
	}

}
