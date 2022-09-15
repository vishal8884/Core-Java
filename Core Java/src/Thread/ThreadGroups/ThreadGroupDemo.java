package Thread.ThreadGroups;

public class ThreadGroupDemo {

	public static void main(String[] args) {
		System.out.println("Thread group name :: "+Thread.currentThread().getThreadGroup().getName());
		System.out.println("Thread group parent name :: "+Thread.currentThread().getThreadGroup().getParent().getName());              System.out.println();
		
		
		
		
		ThreadGroup parent = new ThreadGroup("Parent");
		System.out.println("parent thred name2 :: "+parent.getName());
		
		ThreadGroup child = new ThreadGroup(parent,"Child");
		System.out.println("child thread group name :: "+child.getName()+"    parent of child :: "+child.getParent().getName());           System.out.println();
		
		
		
		child.setMaxPriority(4); // all thread in this thread group will have this priority

		
		
		Thread thread1 = new Thread(child, "Thread 1");
		Thread thread2 = new Thread(child, "Thread 2");
		System.out.println("thread1 thread group name :: "+thread1.getThreadGroup().getName());
		System.out.println("thread1 priority  :: "+thread1.getPriority());
	}

}
