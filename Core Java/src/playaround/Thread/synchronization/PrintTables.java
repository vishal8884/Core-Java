package playaround.Thread.synchronization;

public class PrintTables {

	public synchronized void printTable(int n) {// synchronized method
		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i+"     Thread name :: "+Thread.currentThread().getName());
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}