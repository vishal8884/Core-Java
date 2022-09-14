package Thread.sychronization.blocks;

public class DisplayMessage {
	
	//1) method 1 using this

	public void sayHello(String name) {   
		
		
		//Any other code before          (this helps us to improve app performance by sync to required code only
		
		synchronized (this) {
			for(int i=1;i<=10;i++) {
				System.out.println("how are you "+name);
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}                            //Untill the thread finished the excetion of this synchronized block code...no other thread can enter this block     
		
		
		//Any other code can go here after
		
	}
	
	
	//2) method 2 class level lock
	
    public void sayHello2(String name) {   
		
		
		//Any other code before          (this helps us to improve app performance by sync to required code only
		
		synchronized (DisplayMessage.class) {   //class level lock
			for(int i=1;i<=10;i++) {
				System.out.println("how are you "+name);
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}                            //Untill the thread finished the excetion of this synchronized block code...no other thread can enter this block     
		
		
		//Any other code can go here after
		
	}
    
    
    //3) method 3 using any object
    
    
    public void sayHello3(String name) {   
		
		
		//Any other code before          (this helps us to improve app performance by sync to required code only
		
		synchronized (DisplayMessage.class) {   //class level lock
			for(int i=1;i<=10;i++) {
				System.out.println("how are you "+name);
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}                            //Untill the thread finished the excetion of this synchronized block code...no other thread can enter this block     
		
		
		//Any other code can go here after
		
	}
}
