package Thread.Assignment;

public class OddNumberThread implements Runnable {

	@Override
	public synchronized void run() {
		for (int i = 1; i <= 10; i++) {
			if(i%2 != 0) {
				System.out.println("odd :: "+i);
			}
			try { Thread.sleep(2);} catch (InterruptedException e) { e.printStackTrace();}
		}
	}

}
