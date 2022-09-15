package Thread.ThreadCommunication;

public class MyThread extends Thread{

	int total;
	
	@Override
	public void run() {
		System.out.println("child thread is calculating the sum");
		
		synchronized (this) {
			for(int i=1;i<=100;i++) {
				total = total + i;
			}
			this.notify();  //4) it does addition and releases the lock ...so the code after wait() executes
		}
	}
}
