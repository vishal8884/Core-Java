package playaround.Thread.MultiThreading;

public class PriorityInThread {

	public static void main(String[] args) {
		GreetingsService gs = new GreetingsService();

		Thread t1 = new Thread(() -> {
			Thread.currentThread().setName("Thread----------------1");
			gs.sayHello(10);
		});
		
		Thread t2 = new Thread(() -> {
			Thread.currentThread().setName("Thread-2");
			gs.sayHello(5);
		});

		t1.start();
		t2.start();
		
		

		
	}

}
