package playaround.Thread.MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TablesGeneratorService {
	public TablesGeneratorService() {
		
	}
	
	public void printTables(int a) {
		for(int i=1;i<=10;i++) {
			System.out.println(a+" * "+i+" = "+a*i+"      Thread name :: "+Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


public class ThreadPoolPlay {
	public static void main(String[] args) throws InterruptedException {
		TablesGeneratorService service = new TablesGeneratorService();
		
		Thread t1 = new Thread(() -> {
			//Thread.currentThread().setName("Thread--1");
			service.printTables(8);
		});
		Thread t2 = new Thread(() -> {
			//Thread.currentThread().setName("Thread--2");
			service.printTables(5);
		});
		
		 ExecutorService pool1 = Executors.newFixedThreadPool(5);
		 ExecutorService pool2 = Executors.newFixedThreadPool(5);
		 
		 pool1.execute(t1);

		 pool2.execute(t2);
		 
		 
		 System.out.println("shutting down pool1 and pool2");
		 pool1.shutdown();
		 pool2.shutdown();
	}

}













