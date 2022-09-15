package Thread.ThreadGroups;

public class ThreadGroupMethods {

	public static void main(String[] args) throws InterruptedException {
		ThreadGroup mtg = new ThreadGroup("MyThreadGroup");
		
		CustomThread thread1 = new CustomThread(mtg, "Thread 1");
		CustomThread thread2 = new CustomThread(mtg, "Thread 2");
		CustomThread thread3 = new CustomThread(mtg, "Thread 2");
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		System.out.println("active count :: "+mtg.activeCount());
		System.out.println("active thread group count ::"+mtg.activeGroupCount()); //if this threadgroup has parent then this will have that val..here its 0
		System.out.println();
		
		mtg.list();   //prints info abut threadgroup..used for debugging only
		
		
		Thread.sleep(5000); 
		
		System.out.println("active count after sleep::"+mtg.activeCount());  //as thread is sleeping for 5 sec all 3 threads (thread1,thread2,thread3) complets its run/start method
		                                        //for 1 second sleep  we will get 3 active count...
		
		mtg.list();
		                 
	}

}
