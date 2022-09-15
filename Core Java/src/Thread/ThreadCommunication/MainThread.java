package Thread.ThreadCommunication;

public class MainThread {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("starting the main method");System.out.println();
		
		MyThread t1 = new MyThread(); 
		t1.start();                       // 1) child thread is started
		

		synchronized (t1) {               // 2) main thread gets the lock on child thread object (now no other thread can acquire lock on this)
			System.out.println("main thread is going to wait");
			t1.wait();                   // 3) main thread releases the lock by invoking wait()...wait() Causes the current thread (main) to wait until it is awakened
			System.out.println("main thread nofied");
			System.out.println("total :: "+t1.total);
		}
		
		
	//	t1.join();                                //alternatively we can use this also
	//	System.out.println("total :: "+t1.total);
		
	}

}
