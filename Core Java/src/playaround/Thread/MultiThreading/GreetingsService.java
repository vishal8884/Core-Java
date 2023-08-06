package playaround.Thread.MultiThreading;

public class GreetingsService {

	public void sayHello(int n) {// synchronized method
		for (int i = 1; i <= n; i++) {
			System.out.println("Hello    -> "+i+"     Thread name :: "+Thread.currentThread().getName()
					+"   state :: "+Thread.currentThread().getThreadGroup());
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}