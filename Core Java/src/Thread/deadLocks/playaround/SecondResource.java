package Thread.deadLocks.playaround;

public class SecondResource {

	public synchronized void method1(FirstResource fr) {
		System.out.println("method1 of second resource");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("invoking method2 of first resource");
		fr.method2();
	}

	public synchronized void method2() {
		System.out.println("method2 of second resource");
	}

}
