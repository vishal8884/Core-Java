package Generics;

public class MyGenericClass<T> {

	T obj;
	
	public MyGenericClass(T obj) {
		this.obj = obj;
	}
	
	public void displayObjectDetails() {
		System.out.println("They type of object is :: "+obj.getClass().getName());
	}
	
	public T getObject() {
		return obj;
	}
}
