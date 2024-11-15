package pij.day15.fibonacci;

/**
 * Recursive implementation of the Fibonacci function using memoisation.
 * Initial attempt.
 */
public class FibonacciFirstAttempt {

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
        long[] precalculated = new long[n+1];
        for (int i = 0; i < precalculated.length; i++) {
            precalculated[i] = -1; // to indicate "not calculated yet"
        }
        return fib(n, precalculated);
    }

    /**
     * Returns the value of the Fibonacci function for n, assuming that
     * n is greater than or equal to precalculated.length and that
     * precalculated[i] is either -1 or the value of the Fibonacci function
     * for i less than or equal to n. Modifies precalculated such that after
     * the method call, precalculated[i] will be the value of the Fibonacci
     * function for i less than or equal to n.
     *
     * @param n the input parameter for the Fibonacci function
     * @param precalculated precalculated[i] stores value of the Fibonacci
     *                      function for i, or -1
     * @return the value of the Fibonacci function for n
     * @throws ArrayIndexOutOfBoundsException if n is less than zero or n is
     *                                        greater than or equal to
     *                                        precalculated.length
     * @throws NullPointerException if precalculated is null
     */
    private static long fib(int n, long[] precalculated) {
        if (precalculated[n] != -1) {
            return precalculated[n];
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long result = fib(n - 1, precalculated) + fib(n - 2, precalculated);
        precalculated[n] = result;
        return result;
    }
}
