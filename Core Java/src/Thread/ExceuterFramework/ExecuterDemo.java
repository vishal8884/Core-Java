package Thread.ExceuterFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterDemo {

	public static void main(String[] args) {
         CheckProcessorTask[] cps = {new CheckProcessorTask("ATM"), new CheckProcessorTask("Bank"),new CheckProcessorTask("mobile"), new CheckProcessorTask("Web")};
         
         ExecutorService service = Executors.newFixedThreadPool(2);   //creates and manage all 4 above tasks using 2 threads
                                                                      //these 2 threads are shared by executers service to perform checkprocessor task
         
         for(CheckProcessorTask checkProcesorTask : cps) {
        	 service.submit(checkProcesorTask);
         }
         
         service.shutdown();
	}

}
