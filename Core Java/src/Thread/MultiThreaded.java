package Thread;

public class MultiThreaded extends Thread{

	public static void main(String[] args) throws InterruptedException {

		MultiThreaded mp = new MultiThreaded();
		mp.start();
		
		for(int j=1; j<=20; j++) {
			System.out.println("j :: "+j);
			Thread.sleep(1000);
		}
	}
	
	public void run() {
		for(int i=1; i<=20; i++) {
			System.out.println("i :: "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
