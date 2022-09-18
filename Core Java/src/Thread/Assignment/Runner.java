package Thread.Assignment;

public class Runner {

	public static void main(String[] args) throws InterruptedException {

		EvenNumberThread et = new EvenNumberThread();
		OddNumberThread ot = new OddNumberThread();

		Thread t1 = new Thread(ot);
		Thread t2 = new Thread(et);

		t1.start();
		t2.start();

	}

}
