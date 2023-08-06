package playaround.collections.java8.methodRefereces;

interface app1{
	public void printHello();
}

interface app2 extends app1{
	public void printHello2();
}

class appImpl implements app2{

	@Override
	public void printHello() {
		System.out.println("Hello");
		
	}
	@Override
	public void printHello2() {
		System.out.println("Hello2");
	}
	
}

public class E3 {
	public static void main(String[] args) {
		app1 a1 = new appImpl();
		app2 a2 = new appImpl();
		
		a1.printHello();
	
		a2.printHello();
		a2.printHello2();
	}
}
