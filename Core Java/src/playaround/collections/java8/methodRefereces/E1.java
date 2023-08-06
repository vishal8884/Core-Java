package playaround.collections.java8.methodRefereces;

interface sayable {
	void say();
}

public class E1 {

	public static void main(String[] args) {

		sayable s = E1::sayHello;
		s.say();
	}
	
	
	public static void sayHello() {
		System.out.println("Hello");
	}

}
