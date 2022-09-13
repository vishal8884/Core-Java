package Thread.Yield;

public class YieldDemo {

	public static void main(String[] args) {

		MyThread t = new MyThread();
		t.start();
//		try {
//			t.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		for(int i=1;i<=10;i++) {
			System.out.println("main thread");
		}
	}

}
