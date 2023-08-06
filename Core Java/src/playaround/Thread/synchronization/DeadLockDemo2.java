package playaround.Thread.synchronization;

public class DeadLockDemo2 {

	public static void main(String[] args) {
		String s1 = "vishal";
		String s2 = "lee";

		Thread t1 = new Thread(() -> {
			synchronized (s1) {
                System.out.println("Synchronized s1 on Thread1");

				synchronized (s2) {
					System.out.println("Aquired lock on s2 with Thread1");
				}
			}
			System.out.println("Thread1 done");
		});
		Thread t2 = new Thread(() -> {
			synchronized (s2) {
				System.out.println("Synchronized s2 on Thread2");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
//				synchronized (s1) {
//					System.out.println("Aquired lock on s1 with Thread2");
//				}
			}
			System.out.println("Thread2 done");
		});
		
		t1.start();
		t2.start();
	}

}
