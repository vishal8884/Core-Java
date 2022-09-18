package Thread.Daemon;

public class DaemonDemo {

	public static void main(String[] args) {
		System.out.println("main thread isDeamon :: "+Thread.currentThread().isDaemon());
		
		MyThread myThread = new MyThread();
		myThread.setDaemon(true);
		System.out.println("myThread isDeamon :: "+myThread.isDaemon());
		
		myThread.start();
	}
}
