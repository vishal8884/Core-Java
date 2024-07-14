package concorrency.course2.exercises.DiningPhilosophers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnerApp {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = null;
        Philosopher[] philosophers = null;

        try{
            philosophers = new Philosopher[Constants.NUM_OF_PHILOSOPHERS];
            ChopStick[] chopSticks = new ChopStick[Constants.NUM_OF_CHOPSTICKS];

            //initialize chopsticks
            for(int i=0;i<Constants.NUM_OF_CHOPSTICKS;i++){
                chopSticks[i] = new ChopStick(i);
            }

            executorService = Executors.newFixedThreadPool(Constants.NUM_OF_PHILOSOPHERS);

            //init philosophers
            for(int i=0;i<Constants.NUM_OF_PHILOSOPHERS;i++){
                ChopStick rightChopStick = chopSticks[(i+1) % Constants.NUM_OF_CHOPSTICKS];
                philosophers[i] = new Philosopher(i,chopSticks[i],rightChopStick);
                executorService.execute(philosophers[i]);
            }

            Thread.sleep(Constants.SIMULATION_RUNNING_TIME);

            for(Philosopher philosopher : philosophers){
                philosopher.setFull(true);
            }

        } finally {
            executorService.shutdown();

            while(!executorService.isTerminated())
                Thread.sleep(1000);

            for(Philosopher philosopher : philosophers){
                System.out.println("Philosopher "+philosopher+"  eating count "+philosopher.getEatCounter());
            }
        }

    }
}
