package ExceptionHandling;

public class IllegalArgumentDemo {

	public static void main(String[] args) {

		Thread thread = new Thread();
		thread.setPriority(11);  //gives illegal argument exception
	}
	
	
	public int sum(int a,int b) {
		if(a == 0 || b == 0) {
			throw new IllegalArgumentException("a or b is zero");
		}
		
		return a+b;
	}

}
