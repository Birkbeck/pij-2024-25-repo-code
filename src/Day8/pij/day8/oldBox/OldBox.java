package pij.day8.oldBox;

/**
 * An OldBox stores a reference to an object and can return
 * the stored reference.
 */
public class OldBox {
    /** The stored reference. */
    private Object data;

    /**
     * Constructs an OldBox that stores the given reference.
     *
     * @param data the reference to store
     */
    public OldBox(Object data) {
        this.data = data;
    }

    /**
     * Returns the stored reference.
     *
     * @return the stored reference
     */
    public Object getData() {
        return this.data;
    }
}
