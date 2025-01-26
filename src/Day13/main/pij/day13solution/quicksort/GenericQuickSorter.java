package pij.day13solution.quicksort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Implementation of the recursive quicksort algorithm for lists with
 * arbitrary Comparable elements (non-null), producing a fresh sorted list.
 */
public class GenericQuickSorter {

    /**
     * Returns a fresh sorted version of the method parameter, using the
     * quicksort algorithm.
     *
     * @param sortMe the list of which we want a sorted version; will not be
     *               modified by the method call
     * @return a fresh sorted version of the method parameter
     * @param <E> the element type, it must be possible to compare them
     * @throws NullPointerException if sortMe is null or contains null
     */
    public static <E extends Comparable<? super E>>
            List<E> quicksort(List<E> sortMe) {
        if (sortMe.size() <= 1) {
            return new ArrayList<>(sortMe);
        }
        List<E> left = new ArrayList<>();
        List<E> right = new ArrayList<>();
        E pivot = partition(sortMe, left, right);
        List<E> leftSorted = quicksort(left);
        List<E> rightSorted = quicksort(right);
        leftSorted.add(pivot);
        leftSorted.addAll(rightSorted);
        return leftSorted;
    }

    /**
     * Partitions src into left, right, and the pivot element.
     *
     * @param src will not be changed by the method, has the first element as
     *            pivot, elements starting from index 1 will be copied to left
     *            and to right
     * @param left elements smaller than or equal to the pivot (except the
     *             first element of src itself) are added here
     * @param right elements greater than the pivot are added here
     * @return the first element of src
     * @param <E> the element type
     * @throws NullPointerException if a method parameter is null or
     *  an element of src is null
     * @throws IllegalArgumentException if src is empty
     */
    private static <E extends Comparable<? super E>>
            E partition(List<E> src, List<E> left, List<E> right) {
        if (src.isEmpty()) {
            throw new IllegalArgumentException("source is expected to have a pivot!");
        }
        Iterator<E> srcIter = src.iterator();
        E pivot = srcIter.next();
        while (srcIter.hasNext()) {
            E current = srcIter.next();
            if (current.compareTo(pivot) <= 0) {
                left.add(current);
            } else {
                right.add(current);
            }
        }
        return pivot;
    }
}
