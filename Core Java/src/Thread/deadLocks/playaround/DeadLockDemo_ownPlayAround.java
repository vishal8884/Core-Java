package Thread.deadLocks.playaround;

public class DeadLockDemo_ownPlayAround implements Runnable{
	
	FirstResource fr = new FirstResource();
	SecondResource sr = new SecondResource();
	
	
	//constructor
	public DeadLockDemo_ownPlayAround() {
		Thread t1 = new Thread(this);
		t1.start();             // this is thread of its own
		
		sr.method1(fr);
	}
	

	public static void main(String[] args) {
		new DeadLockDemo_ownPlayAround();

	}

	@Override
	public void run() {
		fr.method1(sr);
	}

}
