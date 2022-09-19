package InnerThread.staticinner;


public class Outer {
	
	static void f1() {
		System.out.println("Outers Static method");
	}
	
	static class Inner {
		
		static void f2() {
			System.out.println("Inners static method");
		}
		
		void f3() {
			System.out.println("non static method inside inner class");
		}
	}

	public static void main(String[] args) {

		Outer.f1();
		Outer.Inner.f2();
		
		Outer.Inner inner = new Outer.Inner();
		inner.f3();
	}

}
