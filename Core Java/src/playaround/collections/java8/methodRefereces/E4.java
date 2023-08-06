package playaround.collections.java8.methodRefereces;

interface F1{
	public int add(int a, int b);
}

public class E4 {

	public static void main(String[] args) {
		F1 f1 = (a,b) -> a+b;
		System.out.println(f1.add(1, 2));
	}

}
