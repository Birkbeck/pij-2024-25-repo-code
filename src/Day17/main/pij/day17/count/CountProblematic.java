package pij.day17.count;

/**
 * Artificial example of a very much non-thread-safe implementation of
 * a method that would always return 0 if its execution were atomic.
 */
public class CountProblematic {
    private int count = 0;

    private void increment() {
        this.count++;
    }
    private void decrement() {
        this.count--;
    }


    /**
     * Returns the current value of the internal counter after first
     * incrementing it and then decrementing it in a non-atomic way.
     * <p>
     * Add "synchronized" after "public" to ensure that always 0 is returned
     * also if different threads have access to the method.
     *
     * @return the current value of the internal counter
     */
    public int getCount() {
        this.count++;
        this.count--;
        return this.count;
    }

    // more complicated version, with similar effect
    /*
    public int getCount() {
        increment();
        decrement();
        return this.count;
    }
    */
}
