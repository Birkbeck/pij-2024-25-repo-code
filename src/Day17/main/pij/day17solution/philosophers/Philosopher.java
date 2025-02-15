package pij.day17solution.philosophers;

import java.util.Objects;

/**
 * A Philosopher can be run by a Thread. Alternates between thinking,
 * hungry, and eating.
 */
public class Philosopher implements Runnable {

    /** The maximum duration for thinking. */
    private static final int MAX_THINK_MILLIS = 5;

    /** The maximum duration for eating. */
    private static final int MAX_EAT_MILLIS = 100;

    /** Helper constant to denote that a fork is currently available. */
    public static final int AVAILABLE = -1;

    /** A Philosopher's id number. At least 0, at most forks.length. */
    private final int id;

    /**
     * The Philosophers' shared forks. Here forks[i] == AVAILABLE means that the
     * fork is available. Otherwise, forks[i] == j means that Philosopher j
     * currently has the fork.
     * Non-null. Entries are AVAILABLE and numbers from 0 to forks.length - 1.
     */
    private final int[] forks;

    /** The message that a Philosopher will state in response to an
     *  interruption of their thread.
     */
    private final String interruptedMessage;

    /**
     * Philosopher i needs forks i and (i+1) % forks.length to eat.
     *
     * @param id    the Philosopher's id number
     * @param forks the forks with information who holds them;
     *              Philosopher.AVAILABLE means "available"
     * @throws IllegalArgumentException if id is negative or at least
     *                                  forks.length
     * @throws NullPointerException if forks is null
     */
    public Philosopher(int id, int[] forks) {
        if (id < 0 || id >= forks.length) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.forks = Objects.requireNonNull(forks);
        this.interruptedMessage = "Who woke me, the Great Philosopher " + id + "?";
    }

    /**
     * Runs a Philosopher's dinner activities, forever.
     * Think, be hungry, (try to) eat.
     */
    @Override
    public void run() {
        while (true) {
            // Thinking!
            try {
                Thread.sleep(getRandom(MAX_THINK_MILLIS));
            } catch (InterruptedException e) {
                System.out.println(this.interruptedMessage);
            }
            // Hungry!
            int[] wantedForks = { this.id, (this.id + 1) % this.forks.length };

            // - try to get both forks...
            for (int fork : wantedForks) {
                while (this.forks[fork] != AVAILABLE) {
                    try {
                        Thread.sleep(1); // cannot sleep long while hungry!
                    } catch (InterruptedException e) {
                        System.out.println(this.interruptedMessage);
                    }
                }
                this.forks[fork] = this.id;
            }

            // - got both forks -- eat!
            System.out.println("Philosopher " + this.id + " is eating!");

            // Eating!
            // That takes a while...
            try {
                Thread.sleep(getRandom(MAX_EAT_MILLIS));
            } catch (InterruptedException e) {
                System.out.println(this.interruptedMessage);
            }

            // a well-educated philosopher releases the forks after
            // eating...
            for (int fork : wantedForks) {
                this.forks[fork] = AVAILABLE;
            }

            // ... and, replenished, go back to thinking
            // (in the next round of the loop)
        }
    }

    /**
     * Helper method to get a random int between 0 and max.
     *
     * @param max the maximum value of the random number
     * @return a random int between 0 and max
     */
    private static int getRandom(int max) {
        return (int) (Math.round(Math.random() * max));
    }
}
