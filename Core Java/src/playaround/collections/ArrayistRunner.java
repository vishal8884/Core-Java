package playaround.collections;

import java.util.ArrayList;

public class ArrayistRunner {

	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<String>();
		
		names.add("Vishal");
		names.add("abcd");
		names.add("hello");
		names.add("abcd");
		
		System.out.println("names list :: "+names);
		
		
//		System.out.println("Index off "+names.lastIndexOf("abcde"));
//		
//		Object[] array = names.toArray();
//		System.out.println("array :: "+Arrays.toString(array));
		
		
		ArrayList sec_list = new ArrayList();
        sec_list = (ArrayList)names.clone();
	}

}
