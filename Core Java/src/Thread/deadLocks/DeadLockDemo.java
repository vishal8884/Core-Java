package Thread.deadLocks;

public class DeadLockDemo implements Runnable{
	
	FirstResource fr = new FirstResource();
	SecondResource sr = new SecondResource();
	
	
	//constructor
	public DeadLockDemo() {
		Thread t = new Thread(this);
		t.start();             // this is thread of its own
		sr.method1(fr);        // this happens in main thread as this is constructor
	}
	

	public static void main(String[] args) {
		new DeadLockDemo();
	}

	@Override
	public void run() {
		fr.method1(sr);
	}

}
