package Thread.ThreadGroups;

public class CustomThread extends Thread{
	
	CustomThread(ThreadGroup g, String name) {
		super(g,name);            //As we extend Thread.class we are passing threadGroup and name to Thread.class constructor
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
