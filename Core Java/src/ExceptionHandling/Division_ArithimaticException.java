package ExceptionHandling;

import java.util.Scanner;

public class Division_ArithimaticException {

	public static void main(String[] args) {

		int divRes = divide(12, 0);
		System.out.println("divRes :: "+divRes);
		
	}

	public static int divide(int a,int b) {
		return a/b;
	}
}
