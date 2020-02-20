package week01.numbers;

import java.math.BigInteger;

/**
 * Demonstrates the use of BigDecimal.
 *
 * @author BCIT
 * @version 2020
 */
public class BigFactorial {

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(String[] args) {
        final int UPPER_BOUND = 15;
        BigInteger factorial = BigInteger.valueOf(1);
        for (int i = 2; i <= UPPER_BOUND; ++i) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
            System.out.println(factorial);
        }
    }
}
