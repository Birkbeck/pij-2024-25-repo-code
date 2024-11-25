package pij.day18.fibonacci;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Driver class for ExecutorService classes. Uses a direct recursive
 * implementation of the Fibonacci function for some computationally
 * intensive tasks.
 */
public class FibonacciExecutorServiceDriver {

    /** Constants for different inputs. */
    private static final int EASY_INPUT_FOR_FIBONACCI = 38;
    private static final int ILLEGAL_INPUT_FOR_FIBONACCI = -10;
    private static final int BIG_INPUT_FOR_FIBONACCI = 46;
    private static final int VERY_BIG_INPUT_FOR_FIBONACCI = BIG_INPUT_FOR_FIBONACCI + 1;

    /**
     * Sleep duration in milliseconds between polling the Future objects
     * for updates on task completion.
     */
    private static final int SLEEP_MILLIS = 500;

    /**
     * Symbols to display during polling of the Futures.
     */
    private static final String BOTH_RUNNING_SYMBOL = "#";
    private static final String FIRST_RUNNING_SYMBOL = ";";
    private static final String SECOND_RUNNING_SYMBOL = ".";

    /**
     * Extracts the result from a given Future.
     *
     * @param future the Future whose result we want to extract
     * @return the result of the Future's task
     * @throws ExecutionException if an exception occurred during the
     *  computation of the Future's task; the ExecutionException wraps
     *  the occurred exception
     * @throws NullPointerException if future is null
     */
    private static <V> V getResult(Future<? extends V> future) throws ExecutionException {
        try {
            return future.get();
        } catch (InterruptedException e) {
            // would be unexpected in the context of this driver class
            throw new RuntimeException(e);
        }
    }

    /**
     * Puts the current thread to sleep for a given duration in milliseconds.
     *
     * @param durationMillis the duration the thread is supposed to sleep
     * @throws IllegalArgumentException if durationMillis is negative
     */
    private static void sleepABit(long durationMillis) {
        try {
            Thread.sleep(SLEEP_MILLIS);
        } catch (InterruptedException e) {
            // would be unexpected in the context of this driver class
            throw new RuntimeException(e);
        }
    }

    /**
     * Runs two instances of a direct implementation of Fibonacci's
     * function concurrently via a given ExecutorService.
     *
     * @param service the ExecutorService that will handle the tasks
     * @param input1 the first input for Fibonacci's function
     * @param input2 the second input for Fibonacci's function
     * @throws NullPointerException if service is null
     */
    public static void runFibonacciConcurrently(ExecutorService service,
                                                int input1, int input2) {
        // make two Callables ...
        Callable<Long> task1 = new FibonacciTask(input1);
        Callable<Long> task2 = new FibonacciTask(input2);
        // ... and hand them over to the ExecutorService, which provides
        // Future objects so we can have an eye on the outcome
        Future<Long> future1 = service.submit(task1);
        Future<Long> future2 = service.submit(task2);
        System.out.println("Computing fib(" + input1 + ") and fib(" + input2
                + ") concurrently...");

        // Two futures having an eye on their tasks concurrently.
        while ((! future1.isDone()) && (! future2.isDone())) {
            sleepABit(SLEEP_MILLIS);
            System.out.print(BOTH_RUNNING_SYMBOL);
        }
        // One of the Futures' tasks must be done!
        Future<Long> finishedFuture; // the Future whose task is done
        Future<Long> stillRunningFuture; // the Future that may not yet be done
        boolean future1finished;
        if (future1.isDone()) {
            finishedFuture = future1;
            stillRunningFuture = future2;
            future1finished = true;
        } else {
            finishedFuture = future2;
            stillRunningFuture = future1;
            future1finished = false;
        }

        // now get the result and report it (or the error)
        try {
            long result = getResult(finishedFuture);
            int input = future1finished ? input1 : input2;
            System.out.println("fib(" + input + ") = " + result);
        } catch (ExecutionException e) {
            informAboutExecutionException(e);
        }

        // run the remaining task to the very end
        while (! stillRunningFuture.isDone()) {
            sleepABit(SLEEP_MILLIS);
            // use different symbol for the slower thread
            System.out.print(future1finished
                    ? SECOND_RUNNING_SYMBOL : FIRST_RUNNING_SYMBOL);
        }

        // let's report the result (or what went wrong)
        try {
            long result = getResult(stillRunningFuture);
            int input = future1finished ? input2 : input1;
            System.out.println("fib(" + input + ") = " + result);
        } catch (ExecutionException e) {
            informAboutExecutionException(e);
        }
    }

    /**
     * Analyses the given ExecutionException and provides a (hopefully useful)
     * message to the user on the terminal output.
     *
     * @param e the ExecutionException about which to inform the user
     * @throws NullPointerException if e is null
     */
    private static void informAboutExecutionException(ExecutionException e) {
        Throwable t = e.getCause();
        System.out.println("Oh no! Something went wrong with the task: "
                + t.getMessage());
    }

    /**
     * Creates an ExecutorService, then runs it with two easy concurrent tasks,
     * and then with two computationally intensive concurrent tasks.
     */
    public static void exerciseExecutorService() {
        ExecutorService service = Executors.newCachedThreadPool();
        //ExecutorService service = Executors.newSingleThreadExecutor();
        runFibonacciConcurrently(service, EASY_INPUT_FOR_FIBONACCI, ILLEGAL_INPUT_FOR_FIBONACCI);
        runFibonacciConcurrently(service, BIG_INPUT_FOR_FIBONACCI, VERY_BIG_INPUT_FOR_FIBONACCI);
        service.shutdown(); // finish the service so that the JVM can finish
    }

    /**
     * Exercises an ExecutorService with several tasks of different difficulty.
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        exerciseExecutorService();
    }
}
