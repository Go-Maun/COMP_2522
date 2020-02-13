package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Random;


/**the ecosystem class.
 *
 * @author keegan
 * @version 2020
 */
public class Ecosystem {
    private ArrayList<Pool> pools;
    private Random random;

    /**
     * creates ecosystem object.
     */
    public Ecosystem() {
        pools = new ArrayList<>();
        random = new Random();
    }

    /**
     * adds a pool to the pools ArrayList.
     * @param newPool the new pool to add
     */
    public void addPool(Pool newPool) {
        if (newPool != null) {
            pools.add(newPool);
        }
    }

    /**
     * clears the pools from the ecosystem.
     */
    public void reset() {
        pools.clear();
    }

    /**
     * gets the total guppy population.
     * @return the total guppy population
     */
    public int getGuppyPopulation() {
        int totalGuppyPopulation = 0;
        for (Pool pool : pools) {
            totalGuppyPopulation += pool.getPopulation();
        }
        return totalGuppyPopulation;
    }

    /**
     * counts how many guppies die due to over crowding.
     * @return the number of guppies that died
     */
    public int adjustForCrowding() {
        int deathsDueToOverCrowding = 0;
        for (Pool pool : pools) {
            deathsDueToOverCrowding += pool.adjustForCrowding();
        }
        return deathsDueToOverCrowding;
    }

    /**
     * populates a pool array.
     * @param ageInWeeksUpperBound the upper bound for age
     * @param ageInWeeksPadding the padding for age
     * @param healthCoefficientUpperBound the health coefficient upperbound
     * @param healthCoefficientLowerBound the health coefficient lowerbound
     * @param femalePercentChance the chance of a female
     * @param pool the pool being used
     */
    public void populatePoolsArrayList(int ageInWeeksUpperBound, int ageInWeeksPadding,
                                       double healthCoefficientUpperBound,
                                       double healthCoefficientLowerBound, double
                                               femalePercentChance, Pool pool) {
        int ageInWeeks = random.nextInt(ageInWeeksUpperBound) + ageInWeeksPadding;
        double healthCoefficient = random.nextDouble() * (healthCoefficientUpperBound
                - healthCoefficientLowerBound) + healthCoefficientLowerBound;
        boolean isFemale = false;
        if (random.nextDouble() < femalePercentChance) {
            isFemale = true;
        }
        Guppy guppy = new Guppy("Poecilia", "reticulata", ageInWeeks,
                isFemale, 0, healthCoefficient);
        pool.addGuppy(guppy);
    }

    public void setupSimulation() {
        final double femalePercentChance = 0.75;
        final double femalePercentChanceSemiahmoo = 0.35;
        final double healthCoefficientSkookumkchuckUpperBound = 0.81;
        final double healthCoefficientSkookumkchuckLowerBound = 0.5;
        final double healthCoefficientSquamishUpperBound = 1.01;
        final double healthCoefficientSquamishLowerBound = 0.8;
        final double healthCoefficientSemiahmooUpperBound = 1.0;
        final double healthCoefficientSemiahmooLowerBound = 0.0;
        final int skookumchuckStartingPopulation = 300;
        final int squamishStartingPopulation = 100;
        final int semiahmooStartingPopulation = 200;
        final int ageInWeeksSkookumkoochUpperBound = 16;
        final int ageInWeeksSquamishUpperBound = 6;
        final int ageInWeeksSemiahmooUpperBound = 35;
        final int ageInWeeksPadding = 10;
        final int ageInWeeksPaddingSemiahmoo = 15;

        final Pool skookumchuck = new Pool("Skookumchuck", 3000.0,
                42.0, 7.9, 0.9);
        pools.add(skookumchuck);
        final Pool squamish = new Pool("Squamish", 15000.0,
                39, 7.7, 0.85);
        pools.add(squamish);
        final Pool semiahmoo = new Pool("Semiahmoo", 4500.0, 37,
                7.5, 1.0);
        pools.add(semiahmoo);
        for (int currentGuppy = 0; currentGuppy < skookumchuckStartingPopulation; currentGuppy++) {
            populatePoolsArrayList(ageInWeeksSkookumkoochUpperBound, ageInWeeksPadding,
                    healthCoefficientSkookumkchuckUpperBound,
                    healthCoefficientSkookumkchuckLowerBound, femalePercentChance, skookumchuck);
        }
        for (int currentGuppy = 0; currentGuppy < squamishStartingPopulation; currentGuppy++) {
            populatePoolsArrayList(ageInWeeksSquamishUpperBound, ageInWeeksPadding,
                    healthCoefficientSquamishUpperBound,
                    healthCoefficientSquamishLowerBound, femalePercentChance, squamish);
        }
        for (int currentGuppy = 0; currentGuppy < semiahmooStartingPopulation; currentGuppy++) {
            populatePoolsArrayList(ageInWeeksSemiahmooUpperBound, ageInWeeksPaddingSemiahmoo,
                    healthCoefficientSemiahmooUpperBound,
                    healthCoefficientSemiahmooLowerBound, femalePercentChanceSemiahmoo, semiahmoo);
        }
    }

    public void simulate(int numberOfWeeks) {
        setupSimulation();
        for (int weekNumber = 1; weekNumber <= numberOfWeeks; weekNumber++) {
            System.out.println("Week " + weekNumber + " -----------------------------------------");
            simulateOneWeek();
        }
    }

    public void simulateOneWeek() {
        int diedOfOldAge = 0;
        int numberRemoved = 0;
        int starvedToDeath = 0;
        int crowdedOut = 0;
        int newFry = 0;
        for (Pool pool : pools) {
            diedOfOldAge += pool.incrementAges();
            numberRemoved += pool.removeDeadGuppies();
            starvedToDeath += pool.applyNutrientCoefficient();
            numberRemoved += pool.removeDeadGuppies();
            newFry += pool.spawn();
            crowdedOut += pool.adjustForCrowding();
            numberRemoved += pool.removeDeadGuppies();
        }
        System.out.println("Number of deaths due to old age: " + diedOfOldAge
                + "\nNumber of deaths due to starvation: " + starvedToDeath
                + "\nNumber of deaths due to overcrowding: " + crowdedOut
                + "\nNumber of total births this week: " + newFry
                + "\n");
        int totalPopulation = 0;
        for (Pool pool : pools) {
            System.out.println(pool.getName()
                    + " Population this week: " + pool.getPopulation());
            totalPopulation += pool.getPopulation();
        }
        System.out.println("Ecosystem Population this week: " + totalPopulation);
        int numberDied = diedOfOldAge + starvedToDeath + crowdedOut;
        System.out.println("Number died: " + numberDied + "\nNumber removed: " + numberRemoved);
        if (numberDied == numberRemoved) {
            System.out.println("\ndeaths are equal\n");
        } else {
            System.out.println("\ndeaths are not equal\n");
        }
    }
}
