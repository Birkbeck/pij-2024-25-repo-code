package pij.day15.fibonacci;

/**
 * Driver class for computing the Fibonacci function.
 */
public class FibonacciDriver {
    public static void main(String[] args) {
        final int INPUT = 46;
        long nanos1 = System.nanoTime();
        long result = Fibonacci.fib(INPUT);
        //long result = FibonacciFirstAttempt.fib(INPUT);
        long nanos2 = System.nanoTime();
        System.out.println("fib(" + INPUT + ") = " + result);
        System.out.println("The computation took " + (nanos2 - nanos1)/1000 + " microseconds.");
    }
}
