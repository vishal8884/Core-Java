package playaround.Thread.synchronization;

class TablePrinterService{
	public void printTable(int num) {
		synchronized (this) {
			for(int i=1;i<10;i++) {
				System.out.println("num :: "+num+"     mul :: "+i*num);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

public class SynchronizationDemo {

	public static void main(String[] args) {
		TablePrinterService tablePrinterService = new TablePrinterService();
		
		Thread t1 = new Thread(printTableRunner(5,tablePrinterService));
		Thread t2 = new Thread(printTableRunner(10,tablePrinterService));
		
		t1.start();
		t2.start();
		
	}
	
	public static Runnable printTableRunner(int num,TablePrinterService tablePrinterService) {
		return () -> {
			tablePrinterService.printTable(num);
		};
	}
}
