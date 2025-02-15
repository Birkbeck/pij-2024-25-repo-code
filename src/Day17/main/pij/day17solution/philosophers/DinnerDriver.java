package pij.day17solution.philosophers;

import java.util.Arrays;

/**
 * Driver class for the Dining Philosophers' Problem.
 */
public class DinnerDriver {

    /** How many philosophers shall have dinner together? */
    private static final int NUMBER_OF_PHILOSOPHERS = 5;

    /**
     * Runs a dinner with 1 waiter and NUMBER_OF_PHILOSOPHERS philosophers,
     * forever. The waiter keeps an eye on the forks!
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        int[] forks = new int[NUMBER_OF_PHILOSOPHERS];
        Arrays.fill(forks, Philosopher.AVAILABLE);
        System.out.println("The initial forks: " + Arrays.toString(forks));
        Thread waiter = new Thread(new Waiter(forks));
        waiter.start();
        for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
            Thread philosopher = new Thread(new Philosopher(i, forks));
            philosopher.start();
        }
    }
}
