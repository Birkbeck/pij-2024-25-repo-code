package pij.day13.fibonacci;

/**
 * Computes the Fibonacci function fib for int values of 0 or more.
 * For such values, the function is defined as follows:
 * <p>
 * fib(0) = 0 <br>
 * fib(1) = 1 <br>
 * fib(n) = fib(n-1) + fib(n-2) if n > 1
 */
public class Fibonacci {

    /**
     * Returns the value of the Fibonacci function on n. Negative inputs lead
     * to an IllegalArgumentException.
     *
     * @param n we would like to know the value of the Fibonacci function on n
     * @return the value of the Fibonacci function on n
     * @throws IllegalArgumentException if n is negative
     */
    public static long fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Illegal negative value " + n);
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
}
