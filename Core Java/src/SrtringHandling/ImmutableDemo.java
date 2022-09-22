package SrtringHandling;

public class ImmutableDemo {

	public static void main(String[] args) {

		String s1 = "Hello";
		String s2 = "World";
		
		System.out.println("before concat  s1 :: "+s1+"   s2 :: "+s2);
		
		s1.concat(s2);   //this creates new string which needs to be used...s1 will not be changed....if no assignment after sometime garbage collection will be done`
 
		
		System.out.println("after concat  s1 :: "+s1+"   s2 :: "+s2);
		
		
	}

}
