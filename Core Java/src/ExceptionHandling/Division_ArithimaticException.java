package ExceptionHandling;

import java.util.Scanner;

public class Division_ArithimaticException {

	public static void main(String[] args) {

		try {
		    int divRes = divide(12, 0);
			System.out.println("divRes :: "+divRes);
		}
		catch (Exception e) {
			System.out.println("Please do not div by zero :: "+e);
		}
	
		System.out.println("after exception");
	}

	public static int divide(int a,int b) {
		   return a/b;
	}
}
