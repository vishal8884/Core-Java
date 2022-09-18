package Thread.Assignment.java8;

public class Same {

	public static void main(String[] args) {

		Thread odd = new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					if(i%2 != 0) {
						System.out.println("odd :: "+i);
					}
					try { Thread.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
				}
			}
		};
		
		Thread even = new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					if(i%2 == 0) {
						System.out.println("even :: "+i);
					}
					try { Thread.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
				}
			}
		};
		
		odd.start();
		even.start();
	}

}
