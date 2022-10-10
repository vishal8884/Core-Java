package Generics;

public class Runner {

	public static void main(String[] args) {

		MyGenericClass<String> s = new MyGenericClass<>("vishal");
		s.displayObjectDetails();
		System.out.println("s obj :: "+s.getObject());
		
		
		MyGenericClass<Integer> i = new MyGenericClass<>(123);
		i.displayObjectDetails();
		System.out.println("i obj :: "+i.getObject());
		
		MyGenericClass<Double> d = new MyGenericClass<>(12.312);
		d.displayObjectDetails();
		System.out.println("d obj :: "+d.getObject());
		
	}

}
