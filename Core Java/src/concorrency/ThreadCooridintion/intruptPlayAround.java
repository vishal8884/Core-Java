package concorrency.ThreadCooridintion;

public class intruptPlayAround {
    public static void main(String[] args) {
        Thread thread = new Thread(new SleepingThread());
        thread.start();

        for(int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Waiting for seconds before intrupt.... Count down:: "+i);
        }

        thread.interrupt();
    }
}


class SleepingThread implements Runnable{

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("inside try");
                Thread.sleep(100000000);
            } catch (InterruptedException e) {
                 throw new RuntimeException(e);  //if we dont throw this exception app wont stop waiting even if we intrupt the thread
            }
        }
    }
}
