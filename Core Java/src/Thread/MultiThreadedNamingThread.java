package Thread;

public class MultiThreadedNamingThread extends Thread{

	public static void main(String[] args) throws InterruptedException {

		MultiThreadedNamingThread mp = new MultiThreadedNamingThread();
		mp.start();
		
		Thread currentThread = Thread.currentThread();                     // by default it is having name main as its in main method
		System.out.println("Thread name is :: "+currentThread.getName());

	}
	
	public void run() {
		Thread currentThread = Thread.currentThread();
		currentThread.setName("name2");
		System.out.println("Thread name is :: "+currentThread.getName());
	}

}
