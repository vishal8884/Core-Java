package Thread.Runnable;

public class CheckProcessor implements Runnable {    //this is preferable as we can extend other classes

	public static void main(String[] args) {

		CheckProcessor cp = new CheckProcessor();
		Thread t = new Thread(cp);
		t.start();
	}

	@Override
	public void run() {
		System.out.println("Processed the checks");
	}
}
