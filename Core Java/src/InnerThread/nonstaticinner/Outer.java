package InnerThread.nonstaticinner;

public class Outer {

	private static int x = 50;
	private int y;

	public Outer(int y) {
		this.y = y;
	}

	void f1() {
		System.out.println("outer classes non static method called");
	}

	class Inner {                                                     // we cannot have static method inside non static inner class

		private int y;

		public Inner(int y) {
			this.y = y;
		}

		void f2() {
			System.out.println("outer class x :: " + Outer.x);
			System.out.println("outer class y :: " + Outer.this.y);
			System.out.println("inner class y :: " + this.y);
		}
	}

	public static void main(String[] args) {

		Outer outer = new Outer(80);
		outer.f1();

		Outer.Inner inner = outer.new Inner(30);
		inner.f2();
		
		System.out.println(inner.y);
	}

}
