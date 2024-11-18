package pij.day16.map;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

/**
 * Class to illustrate the use of a functional interface as a parameter type
 * in a "higher-order function" in Java. Here both the functional interface
 * IntToIntFunction and the use directly on an array are somewhat atypical
 * for Java code as the Java API provides existing alternatives.
 */
public class ArrayMapper {

    /**
     * Maps f to all array elements and returns the result in a new array.
     *
     * @param f the function to apply on all array elements
     * @param data the array to which we want to map f
     * @return [f(data[0]), ..., f(data[data.length-1])]
     * @throws NullPointerException if data is null or
     *  if f is null and data.length is positive
     */
    public static int[] map(IntToIntFunction f, int[] data) {
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = f.apply(data[i]);
        }
        return result;
    }

    /**
     * Map function for arrays with the functional interface IntUnaryOperator
     * from the Java API, implemented with streams. This is the style that
     * is likely to be used in existing Java code.
     *
     * @param f the function to apply on all array elements
     * @param data the array on whose elements we want to apply f
     * @return [f(data[0]), ..., f(data[data.length-1])]
     * @throws NullPointerException if f or data is null
     */
    public static int[] mapWithJavaAPI(IntUnaryOperator f, int[] data) {
        return Arrays.stream(data)
                     .map(f)
                     .toArray();
    }
}
