package pij.day13solution.fibonacciLoop;

public class FibLoop {
    public static long fibIterative(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        // n > 1: fib(n) = fib(n-2) + fib(n-1)
        long secondToLast = 0;
        long last = 1;
        long result = -1; // dummy initalisation
        for (int i = 2; i <= n; i++) {
            result = secondToLast + last; // now contains fib(i)
            secondToLast = last;
            last = result;
        }
        return result;
    }
}
