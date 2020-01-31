package ca.bcit.comp2522.labs.lab03;
import java.util.ArrayList;
import java.util.Random;

/**
 * the plantation class.
 *
 * @author keegan
 * @version 2020
 */
public class Plantation {
    private ArrayList<Tree> farm = new ArrayList<>();
    private final Random random = new Random();

    /** returns the size of the farm.
     *
     * @return an integer for the farms size
     */
    public int size() {
        return farm.size();
    }

    /** adds a tree to the farm.
     *
     * @param tree the tree object
     * @return the size of the farm
     */
    public int add(Tree tree) {
        if (tree == null) {
            throw new NullPointerException();
        } else {
            farm.add(tree);
            return farm.size();
        }
    }

    /** adds a random number of random trees to the farm.
     *
     * @return the number of trees that the seed method planted
     */
    public int seed() {
        final int upperboundTreesToPlant = 9990;
        final int treesToPlantPadding = 11;
        final int treeAgeUpperBound = 1001;
        final int ten = 10;
        final int circumferencePadding = 90;
        final int treeTypeUpperbound = 3;
        int treesToPlant = random.nextInt(upperboundTreesToPlant) + treesToPlantPadding;
        for (int treeNumber = 0; treeNumber < treesToPlant; treeNumber++) {
            int treeAge = random.nextInt(treeAgeUpperBound);
            int treeType = random.nextInt(treeTypeUpperbound);
            double treeCircumference = ten + random.nextDouble() * circumferencePadding;
            Tree tree = new Tree(Tree.Species.values()[treeType], treeAge, treeCircumference);
            farm.add(tree);
        }
        return treesToPlant;
    }

    /** calculates how many trees can be harvested.
     *
     * @param minCircumference the minimum required circumference for a tree to be harvested
     * @return the total amount of trees that can be cut down
     */
    public int harvestCount(double minCircumference) {
        int totalTreesToCutDown = 0;
        for (Tree trees : farm) {
            if (trees.getCircumferenceInCentimeters() >= minCircumference) {
                totalTreesToCutDown++;
            }
        }
        return totalTreesToCutDown;
    }

}
