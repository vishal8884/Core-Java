package concorrency.ThreadCooridintion.ref;

import java.math.BigInteger;

public class temp {
    public static void main(String[] args) {
        BigInteger power = calculatePower(BigInteger.TWO, BigInteger.valueOf(5));
        System.out.println("power :: "+power);
    }


    public static BigInteger calculatePower(BigInteger base, BigInteger power){
        BigInteger temp = base;

        for (BigInteger i = BigInteger.ZERO; i.compareTo(power.subtract(BigInteger.ONE)) != 0; i = i.add(BigInteger.ONE)){
            base = base.multiply(temp);
        }

        return base;
    }

    /*
    4
    8
    16
     */

    public static BigInteger calculateFactorial(long input){
        BigInteger result = BigInteger.ONE;

        for(long i = input ; i>0 ;i--){
            result = result.multiply(BigInteger.valueOf(i));
            System.out.println("res :: "+result+"    i :: "+i);
        }

        return result;
    }

    //1 * 10
}

/*
1 * 10
10 * 9
90 *
 */