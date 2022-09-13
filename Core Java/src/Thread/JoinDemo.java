package Thread;

import java.util.Scanner;

public class JoinDemo extends Thread{

	static int n,sum = 0;
	
	public static void main(String[] args) {

		long start =  System.currentTimeMillis();
		System.out.println("sum of first 'N' numbers");
		System.out.println("Enter the value");
		
		Scanner sc = new Scanner(System.in);
		
		JoinDemo.n = sc.nextInt();
		
		JoinDemo jd = new JoinDemo();
		jd.start();
		try {
			jd.join();                               //join methods makes sure that the other thread will end here
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		System.out.println("Sum of first :: "+JoinDemo.n+"    numbers is :: "+JoinDemo.sum);
		
		sc.close();
		long end = System.currentTimeMillis();
		
		System.out.println("total time taken     start :: "+start+"     end :: "+end+"       end - start :: "+(end - start)/1000+"    seconds");
	}
	
	public void run() {
		for(int i=1; i<= JoinDemo.n;i++) {
			JoinDemo.sum = JoinDemo.sum +  i;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
