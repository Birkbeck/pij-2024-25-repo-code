package pij.day8.hardcodedBox;

/**
 * An IntegerBox stores a reference to an Integer object and can return
 * the stored reference.
 */
public class IntegerBox {
    /** The stored reference. */
    private Integer data;

    /**
     * Constructs an IntegerBox that stores the given reference.
     *
     * @param data the reference to store
     */
    public IntegerBox(Integer data) {
        this.data = data;
    }

    /**
     * Returns the stored reference.
     *
     * @return the stored reference
     */
    public Integer getData() {
        return this.data;
    }
}
