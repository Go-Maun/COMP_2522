package ca.bcit.comp2522.labs.lab06;

public class WarmUp {
    public static int getSumOfTwoLargest(int[] arrayOfInts) {
        if (arrayOfInts.length < 2) {
            return 0;
        }
        int firstLargest = arrayOfInts[0], secondLargest = arrayOfInts[1];
        for (int i = 2; i < arrayOfInts.length; i++) {
            if (firstLargest < secondLargest && firstLargest < arrayOfInts[i]) {
                firstLargest = arrayOfInts[i];
            } else if (secondLargest < firstLargest && secondLargest < arrayOfInts[i]) {
                secondLargest = arrayOfInts[i];
            }
        }
        return firstLargest + secondLargest;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,1,4};
        int[] arr2 = {1,2,3};
        int[] arr3 = {2,4,6,8,10,12,14};
        int[] arr4 = {14,12,10,8,10,12,14};
        int[] arr5 = {8,8,8,8,8,8,8,8,8,8};
        int[] arr6 = {2,1};
        System.out.println(getSumOfTwoLargest(arr1));
        System.out.println(getSumOfTwoLargest(arr2));
        System.out.println(getSumOfTwoLargest(arr3));
        System.out.println(getSumOfTwoLargest(arr4));
        System.out.println(getSumOfTwoLargest(arr5));
        System.out.println(getSumOfTwoLargest(arr6));
    }
}
