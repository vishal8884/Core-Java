package ExceptionHandling;

public class AssertDemo {

	public static void main(String[] args) {

		int withDrawalAmount = 100;
		int currentBalance = 60;
		
		assert(withDrawalAmount < currentBalance); //need to enable in run configuration
	}

}
