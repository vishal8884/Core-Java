package concorrency.ThreadCooridintion;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoiningThreads {
    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(2L,10000000000L,4L,1L);
        List<FactorialThread> factorialThreads = new ArrayList<>();

        for(Long inputNum : inputNumbers){
            factorialThreads.add(new FactorialThread(inputNum));
        }


        for(FactorialThread factorialThread : factorialThreads){
            factorialThread.setDaemon(true);
            factorialThread.start();
        }

        for(FactorialThread factorialThread : factorialThreads){
            factorialThread.join(2000);  //some thread run for very long time so we set limit here
        }



        for(FactorialThread factorialThread : factorialThreads){
            if(!factorialThread.inProgress){
                System.out.println("FactorialThread execution finished :: "+factorialThread.getFactorial());
            }
            else{
                System.out.println("still inprogress");
            }
        }

    }
}


class FactorialThread extends Thread {

    Long input;
    BigInteger factorial;
    boolean inProgress = true;

    public FactorialThread(Long input){
        this.input = input;
    }

    @Override
    public void run() {
        this.factorial = calculateFactorial(input);
        this.inProgress = false;
    }

    public BigInteger calculateFactorial(long input){
        BigInteger result = BigInteger.ONE;

        for(long i = input ; i>0 ;i--){
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    public BigInteger getFactorial() {
        return factorial;
    }

    public boolean getInprogress(){
        return inProgress;
    }
}
