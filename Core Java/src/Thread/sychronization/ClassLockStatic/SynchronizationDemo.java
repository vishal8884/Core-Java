package Thread.sychronization.ClassLockStatic;

public class SynchronizationDemo {

	public static void main(String[] args) {
		
		MyThread t1 = new MyThread("vishal");
		MyThread t2 = new MyThread("waters");
		
		t1.start();
		t2.start();

	}

}
