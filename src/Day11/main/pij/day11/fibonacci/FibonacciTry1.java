package pij.day11.fibonacci;

/**
 * Computes the n-th Fibonacci number fib(n) for n >= 0 by directly
 * following the definition<p>
 *
 * fib(0) = 0  <br>
 * fib(1) = 1  <br>
 * fib(n) = fib(n-1) + fib(n-2) for n >= 2
 */
public class FibonacciTry1 {

    /**
     * Straightforward recursive implementation for the n-th Fibonacci number.
     *
     * @param n we want the n-th Fibonacci number
     * @return the value of the n-th Fibonacci number fib(n)
     * @throws IllegalArgumentException if n < 0
     */
    public long fib(int n) {
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
