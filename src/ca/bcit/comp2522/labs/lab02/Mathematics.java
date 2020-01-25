package ca.bcit.comp2522.labs.lab02;

import java.util.Random;

/**
 * contains various mathematic formulae.
 *
 * @author Keegan
 * @version 2020
 */
public class Mathematics {

    /**
     * constant for the number PI.
     */
    public static final double PI = 3.14159;

    /**
     * constant for the conversion of one foot to kilometers.
     */
    public static final double ONE_FOOT_TO_KILOMETRE_RATIO = 0.0003048;
    private static final int FORBIDDEN_FIFTEEN = 15;
    private static final int RANDOM_NUMBER_UPPERBOUND = 11;
    private static final int RANDOM_NUMBER_PADDING = 10;

    private Random betweenTenAndTwenty = new Random();

    /**
     * calculates the area of a circle.
     *
     * @param radius the user given radius
     * @return the area of a circle
     */
    public double getCircleArea(double radius) {
        return PI * radius * radius;
    }

    /**
     * calculates the area of a square.
     *
     * @param sideLength the length of the squares sides
     * @return the squares area
     */
    public double getSquareArea(double sideLength) {
        return sideLength * sideLength;
    }

    /**
     * calculates the sum of two numbers.
     *
     * @param firstNumber the first user given number
     * @param secondNumber the second user given number
     * @return the sum of the numbers
     */
    public double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    /**
     * calculates the product of two numbers.
     *
     * @param firstNumber the first user given number
     * @param secondNumber the second user given number
     * @return the product of the numbers
     */
    public double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    /**
     * calculates the difference of two numbers.
     *
     * @param firstNumber the first user given number
     * @param secondNumber the second user given number
     * @return the difference of the numbers
     */
    public double subtract(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    /**
     * calculates the quotient of two numbers.
     *
     * @param firstNumber the first user given number
     * @param secondNumber the secong user given number
     * @return the quotient of the numbers
     */
    public double divide(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            return 0.0;
        }
        return firstNumber / secondNumber;
    }

    /**
     * returns the absolute value of a number.
     *
     * @param numberToAbsolute the user given number
     * @return the absolute value
     */
    public int absoluteValue(int numberToAbsolute) {
        if (numberToAbsolute < 0) {
            return -numberToAbsolute;
        } else {
            return numberToAbsolute;
        }
    }

    /**
     * generates a random number that isnt 15 between 10 and 20 inclusive.
     *
     * @return a random integer
     */
    public int getRandomNumberBetweenTenAndTwentyButNotFifteen() {
        int randomNumber;
        do {
            randomNumber = betweenTenAndTwenty.nextInt(RANDOM_NUMBER_UPPERBOUND)
                    + RANDOM_NUMBER_PADDING;
        } while (randomNumber == FORBIDDEN_FIFTEEN);
        return randomNumber;
    }

    /**
     * converts feet to kilometers.
     *
     * @param feetToConvert the amount of feet to convert
     * @return the number of kilometers the given feet total to
     */
    public double convertFeetToKilometres(double feetToConvert) {
        return feetToConvert * ONE_FOOT_TO_KILOMETRE_RATIO;
    }

    /**
     * calculates the sum of all ints under and including the upperbound.
     *
     * @param inclusiveUpperBoundInteger the inclusive user given upper bound
     * @return the sum af all integers
     */
    public int sumOfInts(int inclusiveUpperBoundInteger) {
        int totalSum = 0;
        for (int currentInteger = inclusiveUpperBoundInteger;
             currentInteger > 0; currentInteger--) {
            totalSum += currentInteger;
        }
        return totalSum;
    }

    /**
     * tests to see if an integer is positive.
     *
     * @param integerToTest the user given integer
     * @return a boolean depending on the int
     */
    public boolean isPositive(int integerToTest) {
        if (integerToTest > 0) {
            return true;
        }
        return false;
    }

    /**
     * tests if an integer is positive.
     *
     * @param integerToTest the user given integer
     * @return a boolean depending on the int
     */
    public boolean isEven(int integerToTest) {
        if (integerToTest % 2 == 0) {
            return true;
        }
        return false;
    }

    /**
     * calculates the total of all even integers under and including the upper bound.
     *
     * @param inclusiveUpperBoundInteger the user given inclusive upper bound
     * @return the sum of all even integers
     */
    public int sumOfEvens(int inclusiveUpperBoundInteger) {
        int totalSum = 0;
        if (inclusiveUpperBoundInteger > 0) {
            for (int currentInteger = inclusiveUpperBoundInteger;
                 currentInteger > 0; currentInteger--) {
                if (isEven(currentInteger)) {
                    totalSum += currentInteger;
                }
            }
        } else {
            for (int currentInteger = inclusiveUpperBoundInteger;
                 currentInteger < 0; currentInteger++) {
                if (isEven(currentInteger)) {
                    totalSum += currentInteger;
                }
            }
        }
        return totalSum;
    }

    /**
     * calculates the sum of all products under and including the upper bound integer.
     *
     * @param inclusiveUpperBoundInteger the user given upper bound
     * @param dividendInteger the user given dividend integer
     * @return the sum af all products
     */
    public int sumOfProducts(int inclusiveUpperBoundInteger, int dividendInteger) {
        int totalSum = 0;
        if (inclusiveUpperBoundInteger > 0) {
            for (int currentInteger = inclusiveUpperBoundInteger;
                 currentInteger > 0; currentInteger--) {
                if (currentInteger % dividendInteger == 0) {
                    totalSum += currentInteger;
                }
            }
        } else {
            for (int currentInteger = inclusiveUpperBoundInteger;
                 currentInteger < 0; currentInteger++) {
                if (currentInteger % dividendInteger == 0) {
                    totalSum += currentInteger;
                }
            }
        }
        return totalSum;
    }
}
