package playaround.collections.java8.methodRefereces;

interface sayable2 {
	String say(String name);
}

public class E2 {

	public static void main(String[] args) {

		sayable2 s = E2::sayHello;
		String res = s.say("Vishal");
		
		System.out.println(res);
	}
	
	
	public static String sayHello(String name) {
		return "Hello "+name;
	}

}
