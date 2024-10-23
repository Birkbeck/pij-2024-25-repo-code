package pij.day8.box;

/**
 * A BoxWrapper allows us to wrap an arbitrary object into a Box of a
 * corresponding type. It also allows us to print a greeting. Its methods
 * are instance methods (non-static), but you could get the same effect
 * with class methods (static).
 */
public class BoxWrapper {

    /**
     * Returns a new Box&lt;T&gt; that contains data.
     *
     * @param data the reference to wrap into a new Box
     * @return a new Box&lt;T&gt; that contains data
     * @param <T> the generic type of the reference to put into a Box
     */
    public <T> Box<T> wrapInBox(T data) { // T has "method scope"
        return new Box<>(data);
    }

    /**
     * Prints a greeting on the screen.
     */
    public void printGreeting() { // T is not known here!
        System.out.println("Greetings from the BoxWrapper!");
    }
}
