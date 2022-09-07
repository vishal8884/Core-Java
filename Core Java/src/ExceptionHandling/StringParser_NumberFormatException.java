package ExceptionHandling;

public class StringParser_NumberFormatException {

	public static void main(String[] args) {
		
		String s = "abcd";
		int i = Integer.parseInt(s);
		
		System.out.println("i :: "+i);
	}
	
}
