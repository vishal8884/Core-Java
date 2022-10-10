package ConcorrectCollections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListProblemSolvedMultipleThreads extends Thread{
	
	
	static CopyOnWriteArrayList<Object> courses = new CopyOnWriteArrayList();

	public static void main(String[] args) {

		ArrayListProblemSolvedMultipleThreads arrayListProblemSolvedMultipleThreads = new ArrayListProblemSolvedMultipleThreads();
		arrayListProblemSolvedMultipleThreads.start();
		
		courses.add("java");
		courses.add("pytohn");
		courses.add("AWS");
		courses.add("Docker");
		
		Iterator<Object> iterator = courses.iterator();
		
		while(iterator.hasNext()) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("iterater next :: "+iterator.next());
			courses.add(Math.random()); //concorunet modification exception occures here as we tried to add after creating a iterator
		}
		
		
		System.out.println("courses at end :: "+courses);
		
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		courses.add("kubernatis");
	}

}
