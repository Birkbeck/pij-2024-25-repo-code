package pij.day13.factorial;

/**
 * Computes the factorial function on int values. The factorial function
 * for positive integers is defined recursively as
 * <p>
 * factorial(1) = 1 <br>
 * factorial(n) = n * factorial(n-1) if n > 1
 */
public class Factorial {
    /**
     * Returns the factorial of n. If n is 0 or less, 1 is returned.
     *
     * @param n the number whose factorial we want to compute
     * @return the factorial of n
     */
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        // recursive case:
        // (1) make the problem smaller
        int smaller = n - 1;

        // (2) solve the smaller problem
        int smallerResult = factorial(smaller);

        // (3) integrate the solution of the smaller problem to solve
        //     the original problem
        int result = n * smallerResult;
        return result;
    }
}
