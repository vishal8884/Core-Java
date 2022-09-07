package ExceptionHandling;

import java.util.Iterator;

public class ArrayIndexOOBDemo {

	public static void main(String[] args) {

		int[] arr = {10,20,30};
		
		System.out.println("elements of array are");
		
		try {
		    for(int i=0;i<=arr.length;i++) {
			    System.out.println(arr[i]);
		    }
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("beyond array length :: "+e);
		}
		
		System.out.println("After code");
	}

	
	
	public void test() {
		System.out.println("test called");
	}
}
