package concorrency.course2.multithreadingConcepts;

class Worker implements Runnable {
    private volatile boolean teminated; //without volatile it will fetch from cache instead of main memory
    //in this case we are setting terminated true after the thread is started so sometimes it will read cache which is false and cause inconsistenctcies

    @Override
    public void run() {
        while(!teminated){
            System.out.println("Worker Thread running");
        }
    }

    public boolean isTeminated() {
        return teminated;
    }

    public void setTeminated(boolean teminated) {
        this.teminated = teminated;
    }
}


public class T1_Volatile {
    public static void main(String[] args) throws InterruptedException {

        Worker worker = new Worker();
        Thread t1 = new Thread(worker);

        t1.start();

        Thread.sleep(1000);

        worker.setTeminated(true);
        System.out.println("Thread is terminated");
    }
}
