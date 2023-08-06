package playaround.Thread.MultiThreading.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Task cl

public class ThreadPoolTest {
	// Maximum number of threads in thread pool
	static final int MAX_T = 3;

	public static void main(String[] args) {

		Runnable r1 = printNumbers(10,"t1");
		Runnable r2= printNumbers(10,"t2");
		Runnable r3= printNumbers(10,"t3");
		Runnable r4 = printNumbers(10,"t4");
		Runnable r5 = printNumbers(10,"t5");
		Runnable r6 = printNumbers(10,"t6");
		Runnable r7 = printNumbers(10,"t7");
		Runnable r8 = printNumbers(10,"t8");
		
		ExecutorService pool = Executors.newFixedThreadPool(MAX_T);


		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		pool.execute(r6);
		pool.execute(r7);
		pool.execute(r8);
		

		// pool shutdown ( Step 4)
		pool.shutdown();
	}

	private static Runnable printNumbers(int n,String task) {
		return () -> {
			for(int i=0;i<n;i++) {
				if(i==8 && task.equals("t1") || i==8 && task.equals("t2") ) {
					throw new IllegalArgumentException("Custom exception to test");
				}
				if(i == 0) {
					System.out.println("Thread Initialized   i :: "+i+"     Thread name :: "+Thread.currentThread().getName()+"   task :: "+task);
				}
				else {
					System.out.println("Thread running   i :: "+i+"     Thread name :: "+Thread.currentThread().getName()+"       task :: "+task);
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("--------------------------Thread Exceution completed:: "+Thread.currentThread().getName()+"-------------------------------------");
		};
	}
}