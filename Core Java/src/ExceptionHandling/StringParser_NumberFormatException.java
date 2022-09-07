package ExceptionHandling;

public class StringParser_NumberFormatException {

	public static void main(String[] args) {
		
		String s = "abcd";
		
		try {
		    int i = Integer.parseInt(s);
		    System.out.println("i :: "+i);
		}
		catch (NumberFormatException e) {
			System.out.println("exception :: "+e);
		}
		
		System.out.println("next code");
	}
	
}
