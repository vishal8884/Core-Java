package playaround.Thread.synchronization;

class Table {
	synchronized static void printTable(int n) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}



public class TestStaticSynchronization4 {
	public static void main(String args[]) {
		Thread t1 = new Thread(tablePrintable(1));
		Thread t2 = new Thread(tablePrintable(10));
		Thread t3 = new Thread(tablePrintable(100));
		Thread t4 = new Thread(tablePrintable(1000));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
	
	public static Runnable tablePrintable(int num) {
		return () -> {
			Table.printTable(num);
		};
	}
}