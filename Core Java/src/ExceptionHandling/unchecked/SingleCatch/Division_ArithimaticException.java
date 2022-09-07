package ExceptionHandling.unchecked.SingleCatch;


public class Division_ArithimaticException {

	public static void main(String[] args) {

		try {
		    int divRes = divide(12, 0);
			System.out.println("divRes :: "+divRes);
		}
		catch (Exception e) {
			System.out.println("Please do not div by zero :: "+e);
		} 
		finally {
			System.out.println("will be executed always even if exception or no exception");
			//good place to close resources
		}
	
		System.out.println("after exception");
	}

	public static int divide(int a,int b) {
		   return a/b;
	}
}
