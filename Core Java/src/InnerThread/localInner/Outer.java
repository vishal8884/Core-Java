package InnerThread.localInner;

public class Outer {
	
	void f1() {
		System.out.println("Inside Outers f1()");
		class LocalInner {                              //cannot give access modifiers (private,public etc)
			void f2() {
				System.out.println("inside loccal inner f2()");
			}
		}
		
		LocalInner inner = new LocalInner();
		inner.f2();
	}

	public static void main(String[] args) {

		Outer outer = new Outer();
		outer.f1();               // we invoke f1() and f1() invokes f2() ..so both messages are printed
	}

}
