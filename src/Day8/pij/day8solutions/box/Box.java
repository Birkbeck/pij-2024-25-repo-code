package pij.day8solutions.box;

/**
 * A Box<T> stores a reference to an object and can return the stored reference.
 *
 * @param <T> the type of the reference to store and later retrieve
 */
public class Box<T> {
    /** The stored reference. */
    private T data;

    /**
     * Constructs a Box<T> that stores the given reference.
     *
     * @param data the reference to store
     */
    public Box(T data) {
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
     * Updates the internally stored data reference to the method parameter.
     *
     * @param data the new reference to store
     */
    public void setData (T data) {
        this.data = data;
    }
}
