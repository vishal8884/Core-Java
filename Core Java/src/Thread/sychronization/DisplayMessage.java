package Thread.sychronization;

public class DisplayMessage {

	public synchronized void sayHello(String name) {   //if we mark this as synchronized method then Thread which calls sayHello first accquires lock on this method
		for(int i=1;i<=10;i++) {
			System.out.println("how are you "+name);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
