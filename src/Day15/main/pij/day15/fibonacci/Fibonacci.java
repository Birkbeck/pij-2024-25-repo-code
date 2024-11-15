package pij.day15.fibonacci;

/**
 * Recursive implementation of the Fibonacci function using memoisation.
 * Cleaned-up version with proper use of constants.
 */
public class Fibonacci {

    /**
     * Special value for positions in our memoisation array to indicate that
     * the Fibonacci function has not been computed yet for this position.
     * Note that Fibonacci numbers are always non-negative, so any negative
     * value could be used here.
     */
    private static final long UNKNOWN = -1;

    /**
     * Returns the value of the Fibonacci function for n.
     * Implementation note: uses memoisation, leading to time complexity
     * linear in the value of n.
     *
     * @param n the input parameter for the Fibonacci function
     * @return the value of the Fibonacci function for n
     * @throws IllegalArgumentException if n is less than 0
     */
    public static long fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Illegal negative value " + n);
        }
        long[] precalculated = initPrecalculatedArray(n+1);
        return fib(n, precalculated);
    }

    /**
     * Returns the value of the Fibonacci function for n, assuming that
     * n is greater than or equal to precalculated.length and that
     * precalculated[i] is either UNKNOWN or the value of the Fibonacci
     * function for i less than or equal to n, and assuming that
     * precalculated[i] for the base cases i == 0 and i == 1 is not UNKNOWN.
     * Modifies precalculated such that after the method call,
     * precalculated[i] will be the value of the Fibonacci function for
     * i less than or equal to n.
     *
     * @param n the input parameter for the Fibonacci function
     * @param precalculated precalculated[i] stores value of the Fibonacci
     *                      function for i; if i is not a base case (0 or 1),
     *                      also UNKNOWN is possible
     * @return the value of the Fibonacci function for n
     * @throws ArrayIndexOutOfBoundsException if n is less than zero or n is
     *                                        greater than or equal to
     *                                        precalculated.length
     * @throws NullPointerException if precalculated is null
     */
    private static long fib(int n, long[] precalculated) {
        if (precalculated[n] != UNKNOWN) {
            return precalculated[n];
        }
        long result = fib(n - 1, precalculated) + fib(n - 2, precalculated);
        precalculated[n] = result;
        return result;
    }

    /**
     * Helper method to create and initialise an array of a given length to be
     * used for memoisation during computation of the Fibonacci function for
     * size+1. Contains the values for the base cases at 0 and at 1, UNKNOWN
     * otherwise, to the extent that an array with the given length has space
     * for these values.
     *
     * @param size the length of the returned array
     * @return an array { 0, 1, UNKNOWN, UNKNOWN, ..., UNKNOWN }
     * @throws NegativeArraySizeException if size is less than 0
     */
    private static long[] initPrecalculatedArray(int size) {
        long[] precalculated = new long[size];
        for (int i = 2; i < precalculated.length; i++) {
            precalculated[i] = UNKNOWN;
        }
        if (precalculated.length > 0) {
            precalculated[0] = 0; // F(0)
        }
        if (precalculated.length > 1) {
            precalculated[1] = 1; // F(1)
        }
        return precalculated;
    }
}
