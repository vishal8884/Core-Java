package playaround.Thread.synchronization;

public class Runner {

	public static void main(String[] args) {
		
		PrintTables p = new PrintTables();
		
		Thread t1 = new Thread(() -> {
			Thread.currentThread().setName("Thread1");
			p.printTable(7);
		});
		
		
		Thread t2 = new Thread(() -> {
			Thread.currentThread().setName("Thread2");
			p.printTable(8);
		});
		
		
		//t1.start();
		t1.start();
		System.out.println("----------------------------------End of t1 start---------------------------------------");
		t2.start();
	}
}
