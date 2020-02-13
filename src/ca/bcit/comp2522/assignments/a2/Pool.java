package ca.bcit.comp2522.assignments.a2;

import java.util.Comparator;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

/** the pool class.
 *
 * @author keegan
 * @version 2020
 */
public class Pool {
    /**
     * the default pool name.
     */
    public static final String DEFAULT_POOL_NAME = "Unnamed";

    /**
     * the default pool temp in celsius.
     */
    public static final double DEFAULT_POOL_TEMP_CELSIUS = 40.0;

    /**
     * the minimum pool temp in celsius.
     */
    public static final double MINIMUM_POOL_TEMP_CELSIUS = 0.0;

    /**
     * the maximum pool temp in celsius.
     */
    public static final double MAXIMUM_POOL_TEMP_CELSIUS = 100.0;

    /**
     * the neutral ph level.
     */
    public static final double NEUTRAL_PH = 7.0;

    /**
     * the default nutrient coefficient.
     */
    public static final double DEFAULT_NUTRIENT_COEFFICIENT = 0.50;

    /**
     * the minimum nutrient coefficient.
     */
    public static final double MINIMUM_NUTRIENT_COEFFICIENT = 0.0;

    /**
     * the maximum nutrient coefficient.
     */
    public static final double MAXIMUM_NUTRIENT_COEFFICIENT = 1.0;


    /*
    the final variables below i am not sure about, get help
     */
    private static int numberOfPools = 0;
    private final String name;
    private double volumeLitres;
    private double temperatureCelsius;
    private double pH;
    private double nutrientCoefficient;
    private final int identificationNumber;
    private ArrayList<Guppy> guppiesInPool;
    private Random randomNumberGenerator;

    /**
     * creates default pool object creator.
     */
    public Pool() {
        volumeLitres = 0.0;
        name = DEFAULT_POOL_NAME;
        temperatureCelsius = DEFAULT_POOL_TEMP_CELSIUS;
        pH = NEUTRAL_PH;
        nutrientCoefficient = DEFAULT_NUTRIENT_COEFFICIENT;
        guppiesInPool = new ArrayList<Guppy>();
        randomNumberGenerator = new Random();
        identificationNumber = ++numberOfPools;
    }

    /** creates multi-parameter pool object creator.
     *
     * @param newName the provided name
     * @param newVolumeLitres the provided volume in litres
     * @param newTemperatureCelsius the provided temperature in celsius
     * @param newPH the provided PH
     * @param newNutrientCoefficient the provided nutrient coefficient
     */
    public Pool(String newName, double newVolumeLitres, double newTemperatureCelsius,
                double newPH, double newNutrientCoefficient) {
        final double maximumPoolPH = 14.0;
        if (newName == null || newName.trim().equals("")) {
            throw new IllegalArgumentException();
        }
        name = newName.trim().substring(0, 1).toUpperCase()
                + newName.trim().substring(1).toLowerCase();
        if (newVolumeLitres < 0.0) {
            newVolumeLitres = 0.0;
        }
        volumeLitres = newVolumeLitres;
        if (MINIMUM_POOL_TEMP_CELSIUS > newTemperatureCelsius
                || newTemperatureCelsius > MAXIMUM_POOL_TEMP_CELSIUS) {
            newTemperatureCelsius = DEFAULT_POOL_TEMP_CELSIUS;
        }
        temperatureCelsius = newTemperatureCelsius;
        if (newPH < 0.0 || newPH > maximumPoolPH) {
            newPH = NEUTRAL_PH;
        }
        pH = newPH;
        if (newNutrientCoefficient < 0.0 || newNutrientCoefficient > 1.0) {
            newNutrientCoefficient = DEFAULT_NUTRIENT_COEFFICIENT;
        }
        nutrientCoefficient = newNutrientCoefficient;
        guppiesInPool = new ArrayList<Guppy>();
        randomNumberGenerator = new Random();
        identificationNumber = ++numberOfPools;
    }

    /**
     * gets the pools name.
     * @return the pools name
     */
    public String getName() {
        return name;
    }

    /**
     * gets the pools volume.
     * @return the pools volume
     */
    public double getVolumeLitres() {
        return volumeLitres;
    }

    /**
     * gets the pools temp.
     * @return the pools temp
     */
    public double getTemperatureCelsius() {
        return temperatureCelsius;
    }

    /**
     * gets the pools pH.
     * @return the pools pH
     */
    public double getPH() {
        return pH;
    }

    /**
     * gets the pools nutrient coefficient.
     * @return the pools nutrient coefficient
     */
    public double getNutrientCoefficient() {
        return nutrientCoefficient;
    }

    /**
     * gets the pools identification number.
     * @return the pools identification number
     */
    public int getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * sets the pools new volume.
     * @param volumeLitres the new volume
     */
    public void setVolumeLitres(double volumeLitres) {
        if (volumeLitres >= 0.0) {
            this.volumeLitres = volumeLitres;
        }
    }

    /**
     * sets the pools temp.
     * @param temperatureCelsius the new temp
     */
    public void setTemperatureCelsius(double temperatureCelsius) {
        if (MINIMUM_POOL_TEMP_CELSIUS > temperatureCelsius
                && temperatureCelsius > MAXIMUM_POOL_TEMP_CELSIUS) {
            this.temperatureCelsius = temperatureCelsius;
        }
    }

    /**
     * sets the pools pH.
     * @param pH the new pH
     */
    public void setPH(double pH) {
        final double maximumPoolPH = 14.0;
        if (pH < 0.0 && pH > maximumPoolPH) {
            this.pH = pH;
        }
    }

    /**
     * sets the pools nutrient coefficient.
     * @param nutrientCoefficient the new nutrient coefficient
     */
    public void setNutrientCoefficient(double nutrientCoefficient) {
        if (nutrientCoefficient < 0.0 && nutrientCoefficient > 1.0) {
            this.nutrientCoefficient = nutrientCoefficient;
        }
    }

    /**
     * adds delta to the current nutrient coefficient.
     * @param delta a positive or negative double
     */
    public void changeNutrientCoefficient(double delta) {
        if ((delta + nutrientCoefficient) > MAXIMUM_NUTRIENT_COEFFICIENT) {
            nutrientCoefficient = MAXIMUM_NUTRIENT_COEFFICIENT;
        } else if ((delta + nutrientCoefficient) < MINIMUM_NUTRIENT_COEFFICIENT) {
            nutrientCoefficient = MINIMUM_NUTRIENT_COEFFICIENT;
        } else {
            nutrientCoefficient += delta;
        }
    }

    /**
     * adds delta to the current pool temperature.
     * @param delta a positive or negative double
     */
    public void changeTemperature(double delta) {
        if ((delta + temperatureCelsius) > MAXIMUM_POOL_TEMP_CELSIUS) {
            temperatureCelsius = MAXIMUM_POOL_TEMP_CELSIUS;
        } else if ((delta + temperatureCelsius) < MINIMUM_POOL_TEMP_CELSIUS) {
            temperatureCelsius = MINIMUM_POOL_TEMP_CELSIUS;
        } else {
            temperatureCelsius += delta;
        }
    }

    /**
     * gets the number of pools created.
     * @return the number of pools created
     */
    public static int getNumberCreated() {
        return numberOfPools;
    }

    /**
     * adds a guppy to the current pool object.
     * @param guppy the guppy object to add
     * @return a boolean based on if the addition was successful
     */
    public boolean addGuppy(Guppy guppy) {
        if (guppy == null) {
            return false;
        } else {
            guppiesInPool.add(guppy);
            return true;
        }
    }

    /**
     * gets the current pools population.
     * @return the number of alive guppies
     */
    public int getPopulation() {
        int populationCount = 0;
        for (Guppy guppy : guppiesInPool) {
            if (guppy.getIsAlive()) {
                populationCount++;
            }
        }
        return populationCount;
    }

    /**
     * applies the nutrient coefficient to the guppies in a pool.
     * @return the number of guppy deaths :(
     */
    public int applyNutrientCoefficient() {
        int numberOfDeathsThisWeek = 0;
        Iterator<Guppy> iter = guppiesInPool.iterator();
        while (iter.hasNext()) {
            Guppy guppy = iter.next();
            double guppyRequiredNutrients = randomNumberGenerator.nextDouble();
            if (guppy.getIsAlive() && guppyRequiredNutrients > nutrientCoefficient) {
                guppy.setIsAlive(false);
                numberOfDeathsThisWeek++;
            }
        }
        return numberOfDeathsThisWeek;
    }

    /**
     * removes all dead guppies from the pool.
     * @return the number of guppies removed
     */
    public int removeDeadGuppies() {
        int numberOfGuppiesRemoved = 0;
        Iterator<Guppy> iter = guppiesInPool.iterator();
        while (iter.hasNext()) {
            Guppy guppy = iter.next();
            if (!guppy.getIsAlive()) {
                iter.remove();
                numberOfGuppiesRemoved++;
            }
        }
        return numberOfGuppiesRemoved;
    }

    /**
     * gets the volume of litres required for the guppies.
     * @return the number of litres required in litres
     */
    public double getGuppyVolumeRequirementInLitres() {
        final double millilitersToLitresConversionNumber = 1000;
        double numberOfMillilitresRequired = 0.0;
        for (Guppy guppy : guppiesInPool) {
            if (guppy.getIsAlive()) {
                numberOfMillilitresRequired += guppy.getVolumeNeeded();
            }
        }
        return numberOfMillilitresRequired / millilitersToLitresConversionNumber;
    }

    /**
     * gets the average age in weeks of all guppies in the pool.
     * @return the average age in weeks as a double
     */
    public double getAverageAgeInWeeks() {
        int guppyPopulation = this.getPopulation();
        double totalGuppyAgeInWeeks = 0.0;
        for (Guppy guppy : guppiesInPool) {
            if (guppy.getIsAlive()) {
                totalGuppyAgeInWeeks += guppy.getAgeInWeeks();
            }
        }
        if (guppyPopulation != 0) {
            return totalGuppyAgeInWeeks / guppyPopulation;
        } else {
            return 0.0;
        }
    }

    /**
     * gets the average health coefficient.
     * @return the average health coefficient
     */
    public double getAverageHealthCoefficient() {
        int guppyPopulation = this.getPopulation();
        double totalGuppyHealthCoefficient  = 0.0;
        for (Guppy guppy : guppiesInPool) {
            if (guppy.getIsAlive()) {
                totalGuppyHealthCoefficient += guppy.getHealthCoefficient();
            }
        }
        if (guppyPopulation != 0) {
            return totalGuppyHealthCoefficient / guppyPopulation;
        } else {
            return 0.0;
        }
    }

    /**
     * gets the female percentage from the total population.
     * @return a double representing the female population
     */
    public double getFemalePercentage() {
        int guppyPopulation = this.getPopulation();
        double totalGuppiesThatAreFemale  = 0.0;
        for (Guppy guppy : guppiesInPool) {
            if (guppy.getIsAlive() && guppy.getIsFemale()) {
                totalGuppiesThatAreFemale += 1;
            }
        }
        if (guppyPopulation != 0) {
            return totalGuppiesThatAreFemale / guppyPopulation;
        } else {
            return 0.0;
        }
    }

    /**
     * gets the median age of all the guppies.
     * @return the median age of all the guppies
     */
    public double getMedianAge() {
        int guppyPopulation = this.getPopulation();
        double totalGuppiesThatAreFemale  = 0.0;
        ArrayList<Integer> guppyAgeArray = new ArrayList<>();
        for (Guppy guppy : guppiesInPool) {
            if (guppy.getIsAlive()) {
                guppyAgeArray.add(guppy.getAgeInWeeks());
            }
        }
        Collections.sort(guppyAgeArray);
        if (guppyAgeArray.size() % 2 == 0.0) {
            return (guppyAgeArray.get(guppyAgeArray.size() / 2)
                    + guppyAgeArray.get((guppyAgeArray.size() / 2) + 1)) / 2;
        } else {
            return guppyAgeArray.get((int) Math.floor(guppyAgeArray.size() / 2));
        }
    }

    /**
     * spawns new guppies into the current pool.
     * @return the number of new guppies born
     */
    public int spawn() {
        int totalNumberOfNewGuppies = 0;
        Iterator<Guppy> iter = guppiesInPool.iterator();
        while (iter.hasNext()) {
            Guppy guppy = iter.next();
            ArrayList<Guppy> newBabies = new ArrayList<>();
            if (guppy.getIsAlive()) {
                newBabies = guppy.spawn();
                totalNumberOfNewGuppies += newBabies.size();
                guppiesInPool.addAll(newBabies);
            }
        }
        return totalNumberOfNewGuppies;
    }

    /**
     * increments the age of all guppies and kills the old ones.
     * @return the number of guppies that died of age
     */
    public int incrementAges() {
        int deathsDueToAge = 0;
        Iterator<Guppy> iter = guppiesInPool.iterator();
        while (iter.hasNext()) {
            Guppy guppy = iter.next();
            if (guppy.getIsAlive()) {
                guppy.setAgeInWeeks(guppy.getAgeInWeeks() + 1);
                if (!guppy.getIsAlive()) {
                    deathsDueToAge++;
                }
            }
        }
        return deathsDueToAge;
    }

    public int adjustForCrowding() {
        final double millilitersToLitresConversionNumber = 1000;
        int deathsDueToOverCrowding = 0;
        double currentRequiredWaterVolume = this.getGuppyVolumeRequirementInLitres();
        guppiesInPool.sort(Comparator.comparing(Guppy::getHealthCoefficient));
        Iterator<Guppy> iter = guppiesInPool.iterator();
        if (volumeLitres < currentRequiredWaterVolume) {
            while (iter.hasNext() && volumeLitres < currentRequiredWaterVolume) {
                Guppy guppy = iter.next();
                if (guppy.getIsAlive()) {
                    guppy.setIsAlive(false);
                    currentRequiredWaterVolume -= (guppy.getVolumeNeeded()
                            / millilitersToLitresConversionNumber);
                }

            }
        }
        return deathsDueToOverCrowding;
    }

    @Override
    public String toString() {
        return "Pool{"
                + "name='" + name + '\''
                + ", volumeLitres=" + volumeLitres
                + ", temperatureCelsius=" + temperatureCelsius
                + ", pH=" + pH
                + ", nutrientCoefficient=" + nutrientCoefficient
                + ", identificationNumber=" + identificationNumber
                + ", guppiesInPool=" + guppiesInPool
                + ", randomNumberGenerator=" + randomNumberGenerator
                + '}';
    }
}
