package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Random;

/** the guppy class.
 *
 *
 * @author Keegan Maundrell
 * @version 2020
 */

public class Guppy {

    /**
     * age of a young fish.
     */
    public static final int YOUNG_FISH_AGE_IN_WEEKS = 10;

    /**
     * age of a mature fish.
     */
    public static final int MATURE_FISH_AGE_IN_WEEKS = 30;

    /**
     * maximum age of a fish.
     */
    public static final int MAXIMUM_AGE_IN_WEEKS = 50;

    /**
     * minimum amount of water.
     */
    public static final double MINIMUM_WATER_VOLUME_ML = 250.0;

    /**
     * default genus name.
     */
    public static final String DEFAULT_GENUS = "Poecilia";

    /**
     * default species name.
     */
    public static final String DEFAULT_SPECIES = "reticulata";

    /**
     * default health coefficient.
     */
    public static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;

    /**
     * minimum health coefficient.
     */
    public static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;

    /**
     * maximum health coefficient.
     */
    public static final double MAXIMUM_HEALTH_COEFFICIENT = 1.0;
    private static int numberOfGuppiesBorn = 0;

    private String genus;
    private String species;
    private int ageInWeeks;
    private boolean isFemale;
    private int generationNumber;
    private boolean isAlive;
    private double healthCoefficient;
    private int identificationNumber;
    private Random random = new Random();

    /**
     * constructs a new generic guppy.
     */
    public Guppy() {
        ageInWeeks = 0;
        generationNumber = 0;
        genus = DEFAULT_GENUS;
        species = DEFAULT_SPECIES;
        isFemale = true;
        isAlive = true;
        healthCoefficient = DEFAULT_HEALTH_COEFFICIENT;
        numberOfGuppiesBorn++;
        identificationNumber = numberOfGuppiesBorn;
    }

    /**
     * constructs a guppy with chosen parameters.
     * @param newGenus the given genus
     * @param newSpecies the given species
     * @param newAgeInWeeks the given age
     * @param newIsFemale the given gender
     * @param newGenerationNumber the given generation
     * @param newHealthCoefficient the given health
     */
    public Guppy(String newGenus, String newSpecies, int newAgeInWeeks, boolean newIsFemale,
                 int newGenerationNumber, double newHealthCoefficient) {
        if (newGenus == null || newGenus.trim().equals("")) {
            throw new IllegalArgumentException();
        }
        this.genus =  newGenus.trim().substring(0, 1).toUpperCase()
                + newGenus.trim().substring(1).toLowerCase();
        species = newSpecies.trim().toLowerCase();
        if (newAgeInWeeks < 0) {
            newAgeInWeeks = 0;
        }
        ageInWeeks = newAgeInWeeks;
        isFemale = newIsFemale;
        if (newGenerationNumber < 0) {
            newGenerationNumber = 1;
        }
        generationNumber = newGenerationNumber;
        if (newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            newHealthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
        } else if (newHealthCoefficient < MINIMUM_HEALTH_COEFFICIENT) {
            newHealthCoefficient = MINIMUM_HEALTH_COEFFICIENT;
        }
        healthCoefficient = newHealthCoefficient;
        isAlive = true;
        numberOfGuppiesBorn++;
        identificationNumber = numberOfGuppiesBorn;
    }

    /**
     * increments the guppy's age.
     */
    public void incrementAge() {
        ageInWeeks += 1;
        if (ageInWeeks > MAXIMUM_AGE_IN_WEEKS) {
            isAlive = false;
        }
    }

    /**
     * gets the guppy's genus.
     * @return genus
     */
    public String getGenus() {
        return genus;
    }

    /**
     * gets the guppy's species.
     * @return species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * gets the guppy's age.
     * @return ageInWeeks
     */
    public int getAgeInWeeks() {
        return ageInWeeks;
    }

    /**
     * gets the guppy's gender.
     * @return isFemale
     */
    public boolean getIsFemale() {
        return isFemale;
    }

    /**
     * gets generation number.
     * @return generationNumber
     */
    public int getGenerationNumber() {
        return generationNumber;
    }

    /**
     * gets is alive.
     * @return isAlive
     */
    public boolean getIsAlive() {
        return isAlive;
    }

    /**
     * gets the guppy's health.
     * @return healthCoefficient
     */
    public double getHealthCoefficient() {
        return healthCoefficient;
    }

    /**
     * gets the guppy's identification number.
     * @return identificationNumber
     */
    public int getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * gets the number of guppies born.
     * @return numberOfGuppiesBorn
     */
    public static int getNumberOfGuppiesBorn() {
        return numberOfGuppiesBorn;
    }

    /**
     * sets the guppy's age.
     * @param ageInWeeks the guppy's age
     */
    public void setAgeInWeeks(int ageInWeeks) {
        if (ageInWeeks >= 0 && ageInWeeks <= MAXIMUM_AGE_IN_WEEKS) {
            this.ageInWeeks = ageInWeeks;
        }
    }

    /**
     * sets whether the guppy is alive or not.
     * @param isAlive is the guppy alive
     */
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    /**
     * sets the guppy's health.
     * @param healthCoefficient the user chosen health
     */
    public void setHealthCoefficient(double healthCoefficient) {
        if (healthCoefficient >= MINIMUM_HEALTH_COEFFICIENT
                && healthCoefficient <= MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = healthCoefficient;
        }
    }

    /**
     * gets the needed volume.
     * @return a double
     */
    public double getVolumeNeeded() {
        final double oneAndAHalf = 1.5;
        if (ageInWeeks < YOUNG_FISH_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML;
        } else if (ageInWeeks <= MATURE_FISH_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML * ageInWeeks / YOUNG_FISH_AGE_IN_WEEKS;
        } else if (ageInWeeks <= MAXIMUM_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML * oneAndAHalf;
        } else {
            return 0.0;
        }
    }

    /**
     * changes the health of a guppy.
     * @param delta the amount to change the health by
     */
    public void changeHealthCoefficient(double delta) {
        double newHealthCoefficient = healthCoefficient + delta;
        if (newHealthCoefficient <= MINIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = 0.0;
            isAlive = false;
        } else if (newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
        } else {
            healthCoefficient = newHealthCoefficient;
        }
    }

    /**
     * spawns more guppies depending on guppy gender.
     * @return an array of guppy babies.
     */
    public ArrayList<Guppy> spawn() {
        ArrayList<Guppy> babyGuppies = new ArrayList<>();
        final int minimumAgeForSpawn = 8;
        final int maximumRandomNumberNonInclusive = 101;
        final double healthDivisionNumber = 2.0;
        final double fiftyPercentCap = 0.50;
        if (!isFemale || ageInWeeks < minimumAgeForSpawn) {
            return null;
        }
        double percentChance = random.nextDouble();
        if (percentChance >= fiftyPercentCap) {
            int guppiesToSpawn = random.nextInt(maximumRandomNumberNonInclusive);
            for (int guppyNumber = 0; guppyNumber < guppiesToSpawn; guppyNumber++) {
                Guppy newGuppy = new Guppy(genus, species, 0, random.nextBoolean(),
                        generationNumber + 1, (1.0 + healthCoefficient) / healthDivisionNumber);
                babyGuppies.add(newGuppy);
            }
        }
        return babyGuppies;
    }

    /**
     * the toString method.
     * @return a string
     */
    @Override
    public String toString() {
        return "Guppy{"
                + " genus='" + genus + '\''
                + ", species='" + species + '\''
                + ", ageInWeeks=" + ageInWeeks
                + ", isFemale=" + isFemale
                + ", generationNumber=" + generationNumber
                + ", isAlive=" + isAlive
                + ", healthCoefficient=" + healthCoefficient
                + ", identificationNumber=" + identificationNumber
                + '}';
    }

    /**
     * the equals method.
     * @param obj the object to test
     * @return a boolean
     */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Guppy object = (Guppy) obj;

        if (object.getGenus().equals(this.genus)) {
            return true;
        } else if (object.getSpecies().equals(this.species)) {
            return true;
        } else if (object.getAgeInWeeks() == this.ageInWeeks) {
            return true;
        } else if (object.getIsFemale() == this.isFemale) {
            return true;
        } else if (object.getGenerationNumber() == this.generationNumber) {
            return true;
        } else if (object.getIsAlive() == this.isAlive) {
            return true;
        } else if (object.getHealthCoefficient() == this.healthCoefficient) {
            return true;
        } else {
            return false;
        }
    }

}
