package concorrency.ThreadCooridintion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatePowerParallelyUsingThread {
    public static void main(String[] args) throws InterruptedException {
        PowerCalculatorThread t1 = new PowerCalculatorThread(2l,4l);
        PowerCalculatorThread t2 = new PowerCalculatorThread(3l,3l);
        PowerCalculatorThread t3 = new PowerCalculatorThread(1l,1l);

        double total = 0;

        List<PowerCalculatorThread> powerCalculatorThreads = Arrays.asList(t1,t2,t3);

        for(PowerCalculatorThread powerCalculatorThread : powerCalculatorThreads){
            powerCalculatorThread.start();
            powerCalculatorThread.join(1);
        }

        for(PowerCalculatorThread powerCalculatorThread : powerCalculatorThreads){
            if(powerCalculatorThread.isInprogress()){
                System.out.println("Thread is inprogress "+powerCalculatorThread.getName());
            }
            else{
                System.out.println("res :: "+powerCalculatorThread.getResult());
                total += powerCalculatorThread.getResult();
            }
        }

        System.out.println("total :: "+total);

    }
}

class PowerCalculatorThread extends Thread {
    private long power;
    private long base;
    private double result;
    private boolean inprogress = true;

    public PowerCalculatorThread(long base,long power){
        this.base = base;
        this.power = power;
        this.inprogress= true;
    }


    @Override
    public void run() {
        this.result = Math.pow(base,power);
        this.inprogress = false;
    }

    public long getPower() {
        return power;
    }

    public long getBase() {
        return base;
    }

    public double getResult() {
        return result;
    }

    public boolean isInprogress() {
        return inprogress;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setBase(long base) {
        this.base = base;
    }

    public void setPower(long power) {
        this.power = power;
    }
}
