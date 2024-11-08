package pij.day13.fibonacci;

/**
 * Driver class for class Fibonacci.
 */
public class FibonacciDriver {
    public static void main(String[] args) {
        int input = 6;
        long result = Fibonacci.fib(input);
        System.out.println("fib(" + input + ") = " + result);
    }
}
