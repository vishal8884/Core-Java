package concorrency.course2.exercises.DiningPhilosophers;

import java.util.Random;

public class Philosopher implements Runnable{
    private int id;
    private volatile boolean isFull;
    private ChopStick leftChopStick;
    private ChopStick rightChopStick;
    private Random random;
    private int eatCounter;

    public Philosopher(int id,ChopStick leftChopStick, ChopStick rightChopStick){
        this.id = id;
        this.leftChopStick = leftChopStick;
        this.rightChopStick = rightChopStick;
        random = new Random();
    }


    @Override
    public void run() {
        while (!isFull){
            try {
                think();
                if(leftChopStick.pickup(this,State.LEFT)){
                    if(rightChopStick.pickup(this,State.RIGHT)){
                        eat();
                        rightChopStick.putDown(this,State.RIGHT);
                    }
                    leftChopStick.putDown(this,State.LEFT);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void think() throws InterruptedException {
        System.out.println(this+" is thinking");
        Thread.sleep(random.nextInt(1000));
    }

    public void eat() throws InterruptedException {
        System.out.println(this+" is eating");
        eatCounter++;
        Thread.sleep(random.nextInt(1000));
    }

    public void setFull(boolean full) {
        isFull = full;
    }
    public boolean isFull() {
        return isFull;
    }

    public int getEatCounter(){
        return eatCounter;
    }

    @Override
    public String toString() {
        return "Philosopher "+this.id;
    }
}
