package concorrency.ThreadCooridintion.assignment;

import java.math.BigInteger;

public class ComplexCalculation {
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */

        PowerCalculatingThread thread1 = new PowerCalculatingThread(base1,power1);
        PowerCalculatingThread thread2 = new PowerCalculatingThread(base2,power2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        BigInteger result = thread1.getResult().add(thread2.getResult());

        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            BigInteger baseConstant = base;
            BigInteger baseItr = base;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power.subtract(BigInteger.ONE)) != 0; i = i.add(BigInteger.ONE)){
                baseItr = baseItr.multiply(baseConstant);
            }

            this.base = baseItr;
        }

        public BigInteger getResult() { return result; }
    }
}