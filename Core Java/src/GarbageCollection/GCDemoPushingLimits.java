package GarbageCollection;

public class GCDemoPushingLimits {
	
	int objId;
	

	public GCDemoPushingLimits(int objId) {
		this.objId = objId;
		System.out.println("Created :: "+this.objId);
	}

	public static void main(String[] args) {
		for(int i=1;i<=500000;i++) {
			new GCDemoPushingLimits(i);
		}
	}

	@Override                    
	protected void finalize() {  //This method calls up when the objects in main methods are garbage collected..this overrides jdk 
		System.out.println("Finalized :: "+objId);      //garbage is only collected only when jdk thinks that application is running out of storage
	}
}
