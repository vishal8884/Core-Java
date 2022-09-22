package SrtringHandling.immutable;

public class CustomImutable {
	
	int x;
	
	public CustomImutable(int x) {
		this.x = x;
	}
	
	public CustomImutable change(int x) {
		if(this.x == x) {  //if the value is same as existing object then use same object .
			return this; //stringbuffer maintains string pool it reuses
		}
		else {  //else return newly created object
			return new CustomImutable(x);
		}
	}

	public static void main(String[] args) {
		CustomImutable m1 = new CustomImutable(20);
		CustomImutable m2 = m1.change(20);
		CustomImutable m3 = m2.change(30);
		
        System.out.println(m1 == m2);
        System.out.println(m2 == m3);
		
	}

}
