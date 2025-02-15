package ca.bcit.comp2522.lectures.week01.dataTypes;

/**
 * Demonstrates overflow and underflow.
 *
 * @author BCIT
 * @version 2020
 */
public class Overflow {

    /**
     * Drives the program
     * @param args unused
     */
    public static void main(String[] args) {

        byte aByte = 127;
        aByte++;
        System.out.println(aByte);

        aByte--;
        System.out.println(aByte);

        short aShort = -32_768;
        aShort--;
        System.out.println(aShort);

        aShort++;
        System.out.println(aShort);

        int anInt = Integer.MAX_VALUE;
        System.out.println(anInt);

        anInt++;
        System.out.println(anInt);
    }
}
