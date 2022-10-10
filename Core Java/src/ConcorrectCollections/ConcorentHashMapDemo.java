package ConcorrectCollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcorentHashMapDemo extends Thread{
	
	
	static ConcurrentHashMap<String, Float> courseRatings = new ConcurrentHashMap<>();

	public static void main(String[] args) {

		ConcorentHashMapDemo arrayListProblemSolvedMultipleThreads = new ConcorentHashMapDemo();
		arrayListProblemSolvedMultipleThreads.start();
		
		courseRatings.put("java",4.5f);
		courseRatings.put("pytohn",3.5f);
		courseRatings.put("AWS",4.2f);
		courseRatings.put("Docker",2.1f);
		
		Iterator<String> iterator = courseRatings.keySet().iterator();
		
		while(iterator.hasNext()) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("iterater next :: "+courseRatings.get(iterator.next()));
		}
		
		
		System.out.println("courses at end :: "+courseRatings);
		
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		courseRatings.put("kubernatis",1.4f);
	}

}
