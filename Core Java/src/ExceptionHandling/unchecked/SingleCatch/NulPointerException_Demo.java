package ExceptionHandling.unchecked.SingleCatch;

public class NulPointerException_Demo {

	static ArrayIndexOOBDemo a;
	
	public static void main(String[] args) {

		try {
		    NulPointerException_Demo.a.test();
		}
		catch (NullPointerException e) {
			System.out.println(e);
		}
		
		System.out.println("code after");
	}

}
