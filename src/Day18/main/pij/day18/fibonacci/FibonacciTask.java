package pij.day18.fibonacci;

import pij.day11.fibonacci.FibonacciTry1;

import java.util.concurrent.Callable;

/**
 * A task for the Fibonacci function, implemented in a <i>very</i> inefficient
 * way to keep our executor service busy.
 */
public class FibonacciTask implements Callable<Long> {

    /** The input value that our task will use for its computation. */
    private final int input;

    /**
     * Creates a new FibonacciTask for a given input.
     *
     * @param input the input for the computation of the Fibonacci function
     */
    public FibonacciTask(int input) {
        this.input = input;
    }

    /**
     * Returns the result of the computation of Fibonacci's function on the
     * input provided at object construction time.
     *
     * @return the result of the computation of Fibonacci's function on the
     *  input provided at object construction time
     * @throws IllegalArgumentException if the input provided at object
     *  construction time was negative
     */
    @Override
    public Long call() {
        // No "throws Exception" here; our implementation of call() does not
        // throw any checked exceptions, and we may be "nicer" in our method
        // implementations than what the interface requires from us.
        FibonacciTry1 fibonacci = new FibonacciTry1();
        long result = fibonacci.fib(this.input);
        return result;
    }
}
