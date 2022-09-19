package GarbageCollection;

public class GCDemoSysytemGC {
	
	int objId;
	

	public GCDemoSysytemGC(int objId) {
		this.objId = objId;
		System.out.println("Created :: "+this.objId);
	}

	public static void main(String[] args) {
		
		new GCDemoSysytemGC(1);
		new GCDemoSysytemGC(2);
		
		for(int i=1;i<=100;i++) {  //requesting 100 times to clean up memory
			System.gc();
		}
	}

	@Override                    
	protected void finalize() {  //This method calls up when the objects in main methods are garbage collected..this overrides jdk 
		System.out.println("Finalized :: "+objId);      //garbage is only collected only when jdk thinks that application is running out of storage
	}
}
