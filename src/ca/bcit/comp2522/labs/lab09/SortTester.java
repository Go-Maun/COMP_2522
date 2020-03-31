package ca.bcit.comp2522.labs.lab09;

/**
 * the SortTester class.
 *
 * @author Keegan Maundrell
 * @version 2020
 */
public class SortTester {

    /**
     * Sorts an array in O(n^2) and calculates how long it takes.
     * @param array the array to sort.
     * @return the time it took to run the function.
     */
    public long quadraticSort(int[] array) {
        long beginning = System.nanoTime();
        for (int i = 0; i < array.length - 1; i++) {
            int lowest = array[i];
            int lowestIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < lowest) {
                    lowest = array[j];
                    lowestIndex = j;
                }
            }
            int temp = array[i];
            array[i] = lowest;
            array[lowestIndex] = temp;
        }
        return System.nanoTime() - beginning;
    }

    /**
     * Sorts an array in O(logN) and calculates how long it takes.
     * source: https://www.geeksforgeeks.org/quick-sort/
     *
     * @param array the array to sort.
     * @param low the lowest index.
     * @param high the highest index.
     * @return the time it took to run the function.
     */
    public long logarithmicSort(int[] array, int low, int high) {
        long beginning = System.nanoTime();
        if (low < high) {
            int pi = partition(array, low, high);

            logarithmicSort(array, low, pi - 1);
            logarithmicSort(array, pi + 1, high);
        }
        return System.nanoTime() - beginning;
    }

    /**
     * Calculates the proper location for an index.
     * source: https://www.geeksforgeeks.org/quick-sort/
     *
     * @param array the array to sort.
     * @param low the lowest index.
     * @param high the highest index.
     * @return the time it took to run the function.
     */
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int index = low - 1;

        for (int i = low; i < high; i++) {
            if (array[i] < pivot) {
                index++;
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }
        }
        int temp = array[index + 1];
        array[index + 1] = array[high];
        array[high] = temp;

        return index + 1;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
