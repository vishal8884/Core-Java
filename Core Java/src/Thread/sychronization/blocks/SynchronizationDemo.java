package Thread.sychronization.blocks;

public class SynchronizationDemo {

	public static void main(String[] args) {
		DisplayMessage dm = new DisplayMessage();
		
		MyThread t1 = new MyThread(dm,"vishal");
		MyThread t2 = new MyThread(dm,"waters");
		
		t1.start();
		t2.start();

	}

}
