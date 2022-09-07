package ExceptionHandling.customException;

public class Runner {

	public static void main(String[] args) throws CheckedCustomException {

		//throw new UnCheckedCustomException("business exception occured");
		throw new CheckedCustomException("business exception that needs to be handled");
	}

}
