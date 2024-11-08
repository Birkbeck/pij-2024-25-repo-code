package pij.day13.mergeSorter;

import java.util.Arrays;

/**
 * Provides a method to perform a mergesort on an array of int values.
 */
public class MergeSorter {

    /**
     * Sorts sortMe as a side effect. Sorting is performed using the mergesort
     * algorithm using a divide-and-conquer strategy.
     *
     * @param sortMe to be sorted as a side effect
     * @throws NullPointerException if sortMe is null
     */
    public static void sort(int[] sortMe) {
        if (sortMe.length <= 1) { // base case: arrays of length 0 or 1 are sorted
            return;
        }
        // recursive case:
        // (1) divide the problem into two smaller subproblems
        int middle = sortMe.length / 2;
        int[] left = Arrays.copyOfRange(sortMe, 0, middle);
        int[] right = Arrays.copyOfRange(sortMe, middle, sortMe.length);

        // (2) solve the smaller subproblems
        sort(left);
        sort(right);

        // (3) integrate
        merge(left, right, sortMe);
    }

    /**
     * Merges the contents of a and b into dest, overwriting the content of
     * dest. If a and b are sorted, dest will be sorted as well after the
     * method is run.
     *
     * @param a the first array to merge
     * @param b the second array to merge
     * @param dest the destination array for the merge
     * @throws NullPointerException if a, b, or dest are null
     * @throws ArrayIndexOutOfBoundsException if a.length + b.length > dest.length
     */
    private static void merge(int[] a, int[] b, int[] dest) {
        int aIndex = 0;
        int bIndex = 0;
        int destIndex = 0;
        while (aIndex < a.length && bIndex < b.length) {
            if (a[aIndex] < b[bIndex]) {
                dest[destIndex] = a[aIndex];
                aIndex++;
            } else {
                dest[destIndex] = b[bIndex];
                bIndex++;
            }
            destIndex++;
        }
        // we have reached the end of exactly one of the two arrays;
        // copy the remaining elements from the other one over
        System.arraycopy(a, aIndex, dest, destIndex, a.length - aIndex);
        System.arraycopy(b, bIndex, dest, destIndex, b.length - bIndex);
    }
}
