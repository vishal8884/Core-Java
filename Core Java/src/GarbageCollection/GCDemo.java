package GarbageCollection;

public class GCDemo {

	public GCDemo() {
		System.out.println(this + "Created");
	}

	public static void main(String[] args) {
		new GCDemo();
		new GCDemo();
		//System.gc();
	}

	@Override                    
	protected void finalize() {  //This method calls up when the objects in main methods are garbage collected..this overrides jdk 
		System.out.println(this+" Finalized");      //garbage is only collected only when jdk thinks that application is running out of storage
	}
}
