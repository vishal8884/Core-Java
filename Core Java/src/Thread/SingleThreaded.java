package Thread;

public class SingleThreaded {

	public static void main(String[] args){

		SingleThreaded st = new SingleThreaded();
		
		st.printNumbers();
		
		for(int j=1; j<=20; j++) {
			System.out.print("j :: "+j+"\t");
		}
	}
	
	public void printNumbers() {
		for(int i=1; i<=20; i++) {
			System.out.print("i :: "+i+"\t");
		}
	}

}
