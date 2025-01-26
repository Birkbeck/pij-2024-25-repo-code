package pij.day13solution.mergesortRedux;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Implementation of the recursive mergesort algorithm for lists with
 * arbitrary Comparable elements (non-null), producing a fresh sorted list.
 */
public class GenericMergeSorter {

    /**
     * Returns a fresh sorted version of the method parameter, using the
     * mergesort algorithm.
     *
     * @param sortMe the list of which we want a sorted version; will not be
     *               modified by the method call
     * @return a fresh sorted version of the method parameter
     * @param <E> the element type, it must be possible to compare them
     * @throws NullPointerException if sortMe is null or contains null
     */
    public static <E extends Comparable<? super E>>
            List<E> mergesort(List<E> sortMe) {
        if (sortMe.size() <= 1) {
            return new ArrayList<>(sortMe);
        }
        int middle = sortMe.size()/2;
        List<E> left = sortMe.subList(0, middle);
        List<E> right = sortMe.subList(middle, sortMe.size());
        List<E> leftSorted = mergesort(left);
        List<E> rightSorted = mergesort(right);
        List<E> result = merge(leftSorted, rightSorted);
        return result;
    }

    /**
     * Merges two sorted lists into a fresh sorted list with the same elements.
     *
     * @param a must be sorted, will not be modified
     * @param b must be sorted, will not be modified
     * @return the sorted list with the content of a and b together
     * @param <E> the element type
     * @throws NullPointerException if a or b is null or contains null
     */
    private static <E extends Comparable<? super E>>
            List<E> merge(List<E> a, List<E> b) {
        if (a.isEmpty()) {
            return new ArrayList<>(b);
        }
        if (b.isEmpty()) {
            return new ArrayList<>(a);
        }
        // both lists have at least 1 element
        int total = a.size() + b.size();
        Iterator<E> aIter = a.iterator();
        Iterator<E> bIter = b.iterator();
        List<E> result = new ArrayList<>();
        E aValue = aIter.next();
        E bValue = bIter.next();
        for (int i = 0; i < total; i++) {
            if (aValue == null) { // a is fully in result
                result.add(bValue);
                if (bIter.hasNext()) {
                    bValue = bIter.next();
                }
            } else if (bValue == null) { // b is fully in result
                result.add(aValue);
                if (aIter.hasNext()) {
                    aValue = aIter.next();
                }
            } else if (aValue.compareTo(bValue) <= 0) {
                result.add(aValue);
                if (aIter.hasNext()) {
                    aValue = aIter.next();
                } else {
                    aValue = null; // set marker: a is fully in result
                }
            } else {
                result.add(bValue);
                if (bIter.hasNext()) {
                    bValue = bIter.next();
                } else {
                    bValue = null; // set marker: b is fully in result
                }
            }
        }
        return result;
    }
}
