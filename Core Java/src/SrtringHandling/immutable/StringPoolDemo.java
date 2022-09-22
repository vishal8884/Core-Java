package SrtringHandling.immutable;

public class StringPoolDemo {

	public static void main(String[] args) {

		User user1 = new User(1, "abc");
		User user2 = new User(2, "abc");
		
		System.out.println(user1);
		System.out.println(user2);
		
		
		String s1 = "abcd";
		String s2 = "abcd";
		
		System.out.println("s1 :: "+s1.hashCode());  //same hashcode as both has same string
		System.out.println("s2 :: "+s2.hashCode());
	}

}
