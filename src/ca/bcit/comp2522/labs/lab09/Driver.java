package ca.bcit.comp2522.labs.lab09;

import java.util.Random;


public class Driver {

    public static final int TEN = 10;
    public static final int ONE_HUNDRED = 100;
    public static final int ONE_THOUSAND = 1000;
    public static final int TEN_THOUSAND = 10000;
    public static final int ONE_HUNDRED_THOUSAND = 100000;
    public static final int ONE_MILLION = 1000000;
    public static final int TEN_MILLION = 10000000;


    public static void runQuadratic(Random random, SortTester sort, int arrayElements) {
        long time = 0;
        for (int i = 0; i < TEN; i++) {
            int[] array = new int[arrayElements];
            for (int j = 0; j < arrayElements; j++) {
                array[j] = random.nextInt(TEN_MILLION);
            }
            time += sort.quadraticSort(array);
        }
        System.out.println("time to run 10 quadratic sorting on length 10 arrays: " + time);
        System.out.println("average time to run quadratic sort on length "
                + arrayElements + " : " + time / TEN);
        System.out.println();
    }

    public static void runLogarithmic(Random random, SortTester sort, int arrayElements) {
        long time = 0;
        for (int i = 0; i < TEN; i++) {
            int[] array = new int[arrayElements];
            for (int j = 0; j < arrayElements; j++) {
                array[j] = random.nextInt(TEN_MILLION);
            }
            time += sort.logarithmicSort(array, 0, array.length - 1);
        }
        System.out.println("time to run 10 logarithmic sorting on length 10 arrays: " + time);
        System.out.println("average time to run logarithmic sort on length "
                + arrayElements + " : " + time / TEN);
        System.out.println();
    }

    public static void main(String[] args) {
        Random random = new Random();

        SortTester sort = new SortTester();

        runQuadratic(random, sort, TEN);
        runLogarithmic(random, sort, TEN);

        runQuadratic(random, sort, ONE_HUNDRED);
        runLogarithmic(random, sort, ONE_HUNDRED);

        runQuadratic(random, sort, ONE_THOUSAND);
        runLogarithmic(random, sort, ONE_THOUSAND);

        runQuadratic(random, sort, TEN_THOUSAND);
        runLogarithmic(random, sort, TEN_THOUSAND);

        runQuadratic(random, sort, ONE_HUNDRED_THOUSAND);
        runLogarithmic(random, sort, ONE_HUNDRED_THOUSAND);

        runQuadratic(random, sort, ONE_MILLION);
        runLogarithmic(random, sort, ONE_MILLION);

        runQuadratic(random, sort, TEN_MILLION);
        runLogarithmic(random, sort, TEN_MILLION);
    }
}
