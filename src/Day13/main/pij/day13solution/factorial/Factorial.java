package pij.day13solution.factorial;

/**
 * Direct implementations of the factorial function on int.
 */
public class Factorial {

    /**
     * Returns the factorial of n.
     * Recursive implementation.
     *
     * @param n natural number (including 0) of which we want the factorial
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public static long factorialRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Parameter must not be negative, found " + n);
        }
        if (n == 0) { // base case
            return 1;
        }
        // recursive case: fac(n) = n * fac(n - 1)
        return n * factorialRecursive(n - 1);
    }

    /**
     * Returns the factorial of n.
     * Iterative implementation.
     *
     * @param n natural number (including 0) of which we want the factorial
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public static long factorialIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Parameter must not be negative, found " + n);
        }
        long result = 1; // result for 0
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
