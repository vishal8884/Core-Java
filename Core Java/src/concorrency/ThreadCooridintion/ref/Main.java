package concorrency.ThreadCooridintion.ref;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(22L,12L);
        //100000000L, 3435L, 35435L, 2324L, 4656L, 23L, 5556L

        List<FactorialThread> threads = new ArrayList<>();

        for (long inputNumber : inputNumbers) {
            threads.add(new FactorialThread(inputNumber));
        }

        for (Thread thread : threads) {
            //thread.setDaemon(true);
            thread.start();
        }

        for(int i=0;i<5;i++){
            System.out.println("Sleeping for seconds :: "+i);
            Thread.sleep(1000);
        }

//        for (Thread thread : threads) {
//            thread.join(2000);
//        }

        for (FactorialThread factorialThread : threads) {
            if (factorialThread.isFinished()) {
                System.out.println("Factorial is" + factorialThread.getResult());
            } else {
                System.out.println("The calculation for is still in progress");
            }
        }
    }

    public static class FactorialThread extends Thread {
        private long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;

        public FactorialThread(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
        }

        public BigInteger factorial(long n) {
            BigInteger tempResult = BigInteger.ONE;

            for (long i = n; i > 0; i--) {
                tempResult = tempResult.multiply(new BigInteger((Long.toString(i))));
            }
            return tempResult;
        }

        public BigInteger getResult() {
            return result;
        }

        public boolean isFinished() {
            return isFinished;
        }
    }
}