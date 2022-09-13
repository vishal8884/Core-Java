package Thread.Intrupt;

public class InteruptDemo {

	public static void main(String[] args) {

		MyThread t = new MyThread();
		t.start();
		t.interrupt();
		
		System.out.println("end of main method");
	}

}
