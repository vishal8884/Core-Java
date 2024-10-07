package concorrency.course2.virtualThreads;

public class T1_CreateVirtualThreads {

    public static void main(String[] args) throws InterruptedException {
        approachBuilder();
        approachFactory();
    }

    private static void approachBuilder() throws InterruptedException {
        var virtualThread = Thread.ofVirtual().name("virtual-",0);

        var t1 = virtualThread.start(getRunnable());
        var t2 = virtualThread.start(getRunnable());

        t1.join();
        t2.join();

        System.out.println("Exiting main method");
    }

    private static void approachFactory() throws InterruptedException {
        var virtualThread = Thread.ofVirtual().name("virtual-",0).factory();

        var t1 = virtualThread.newThread(getRunnable());
        var t2 = virtualThread.newThread(getRunnable());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Exiting main method");
    }



    private static Runnable getRunnable(){
        return () -> {
            System.out.println("Started Thread :: "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Finished Thread :: "+Thread.currentThread().getName());
        };
    }
}
