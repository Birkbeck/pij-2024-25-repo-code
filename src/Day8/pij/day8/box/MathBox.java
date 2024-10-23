package pij.day8.box;

/**
 * A MathBox stores a reference to a number and allows us to retrieve
 * the number and to calculate its square root.
 *
 * @param <T> type of the data stored in this MathBox, a subtype of Number
 *           so that T has instance method doubleValue()
 */
public class MathBox<T extends Number> {
    /** The stored reference. */
    private T data; // T is a subtype of Number!

    /**
     * Constructs a Box<T> that stores the given reference.
     *
     * @param data the reference to store
     */
    public MathBox(T data) {
        this.data = data;
    }

    /**
     * Returns the stored reference.
     *
     * @return the stored reference
     */
    public T getData() {
        return this.data;
    }

    /**
     * Returns the square root of the encapsulated number.
     *
     * @return the square root of the encapsulated number
     */
    public double sqrt() {
        double d = this.data.doubleValue();
        return Math.sqrt(d);
    }
}
