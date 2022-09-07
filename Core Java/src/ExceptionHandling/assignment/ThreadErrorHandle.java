package ExceptionHandling.assignment;

public class ThreadErrorHandle {

	public static void main(String[] args) {

		System.out.println("1");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new MyThreadCustomException("intrupted excepted was caught");
		}
		System.out.println("2");
	}

}
