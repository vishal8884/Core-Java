package ExceptionHandling;

public class StaticBlockInit {
	
	static {
		try {
		   int i = 20/0;
		} 
//		catch(ArithmeticException e) {
//			System.out.println(e);
//		}
		finally {
			System.out.println("finally block called");
		}
	}

	public static void main(String[] args) {

	}

}
