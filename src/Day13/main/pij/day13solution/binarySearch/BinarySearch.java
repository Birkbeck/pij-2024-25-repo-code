package pij.day13solution.binarySearch;

import java.util.List;

/**
 * Implementation of binary search for a sorted list. If the list has size n,
 * at most O(log(n)) comparisons are needed to determine whether the list
 * contains a potential element.
 */
public class BinarySearch {

    /**
     * Returns whether sortedList contains value.
     *
     * @param sortedList the list where we are looking for a possible element,
     *                   must be sorted according to the natural order of type E
     * @param value the value that we want to check for containment in
     *              sortedList
     * @return whether sortedList contains value
     * @param <E> the type of the element we are looking for
     * @throws NullPointerException if value is null or sortedList is null
     *  or sortedList contains null
     */
    public static <E extends Comparable<? super E>> boolean find(List<? extends E> sortedList, E value) {
        System.out.println("Call on: " + sortedList);
        if (sortedList.isEmpty()) {
            // the empty list does not contain anything
            return false;
        }
        // recursive case: make the problem smaller
        int middle = sortedList.size() / 2;
        int comparisonResult = sortedList.get(middle).compareTo(value);
        if (comparisonResult == 0) { // found it!
            return true;
        }
        List<? extends E> smaller;
        if (comparisonResult < 0) {
            // value must be after the middle
            smaller = sortedList.subList(middle + 1, sortedList.size());
        } else {
            // value must be before the middle
            smaller = sortedList.subList(0, middle);
        }
        return find(smaller, value);
    }
}
