package Thread;

public class ThreadPriority extends Thread{

	public static void main(String[] args) throws InterruptedException {

		ThreadPriority mp = new ThreadPriority();
		mp.setPriority(MIN_PRIORITY);
		mp.setName("mp1");
		mp.start();
		
		ThreadPriority mp2 = new ThreadPriority();
		mp2.setPriority(MAX_PRIORITY);
		mp2.setName("mp2");
		mp2.start();
		

	}     //No guarantee that thread will occur in order.......but most of the cases it will
	
	public void run() {
		System.out.println("thread name :: "+Thread.currentThread().getName());
	}
	

}
