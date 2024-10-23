package pij.day8.hardcodedBox;

/**
 * A StringBox stores a reference to a String object and can return
 * the stored reference.
 */
public class StringBox {
    /** The stored reference. */
    private String data;

    /**
     * Constructs a StringBox that stores the given reference.
     *
     * @param data the reference to store
     */
    public StringBox(String data) {
        this.data = data;
    }

    /**
     * Returns the stored reference.
     *
     * @return the stored reference
     */
    public String getData() {
        return this.data;
    }
}
