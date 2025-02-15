package pij.day17solution.philosophers;

import java.util.Arrays;
import java.util.Objects;

/**
 * The Waiter watches the philosophers eat, with an eye on the location
 * of the forks.
 */
public class Waiter implements Runnable {

    /** Time for the Waiter to sleep between reports on the forks. */
    private static final int SLEEP_MILLIS = 1000;

    /** Used to track the forks on the table. Non-null.
     *  forks[i] == j for j >= 0 means that Philosopher j has fork i
     *  forks[i] == Philosopher.AVAILABLE means that fork i is available
     */
    private int[] forks;

    public Waiter(int[] forks) {
        this.forks = Objects.requireNonNull(forks);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(SLEEP_MILLIS);
            } catch (InterruptedException e) {
                System.out.println("Who woke me, the Great Philosophers' Waiter?");
            }
            System.out.println("The Waiter observes the forks: "
                    + Arrays.toString(this.forks));
        }
    }
}
