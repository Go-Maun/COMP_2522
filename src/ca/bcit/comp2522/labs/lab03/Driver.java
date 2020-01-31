package ca.bcit.comp2522.labs.lab03;


import java.util.Scanner;


/** the driver class.
 *
 *
 * @author keegan
 *
 * @version 2020
 */
public class Driver {
    /**
     * the max number of seed runs.
     */
    public static final int MAX_NUMBER_OF_SEED_RUNS = 5;
    private static Plantation lotusLandLumber = new Plantation();

    public static void main(String[] args) {
        for (int seedNumber = 0; seedNumber < MAX_NUMBER_OF_SEED_RUNS; seedNumber++) {
            lotusLandLumber.seed();
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Choose a minimum harvest circumference in cm: ");
        double minimumHarvest = input.nextDouble();
        System.out.println("\nThere are " + lotusLandLumber.harvestCount(minimumHarvest)
                + " trees ready to be harvested.");
    }

}
