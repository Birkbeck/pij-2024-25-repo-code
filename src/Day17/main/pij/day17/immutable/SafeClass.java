package pij.day17.immutable;

import java.util.Collections;
import java.util.List;

/**
 * SafeClass is an example of a class whose objects are immutable.
 * Since we cannot modify the state of the objects after construction,
 * they are automatically thread-safe.
 *<p>
 * The class is final so that there cannot be subclasses that might
 * introduce mutator methods.
 */
public final class SafeClass {
    // final fields: will not be replaced by any method, present or future!
    private final List<String> entries;
    private final double value;

    /**
     * Constructs a new SafeClass object.
     *
     * @param entries the entries to store; may be modified after the
     *                constructor call without affecting the new object
     * @param value the value to store
     * @throws NullPointerException if entries is or contains null
     */
    public SafeClass(List<String> entries, double value) {
        this.entries = List.copyOf(entries); // defensive copy
        this.value = value;
    }

    // no mutator!

    /**
     * Returns the value stored in this object.
     *
     * @return the value stored in this object
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Returns an unmodifiable view of the entries of this SafeClass object.
     *
     * @return an unmodifiable view of the entries of this SafeClass object.
     */
    public List<String> getEntries() {
        // Using the wrapper Collections.unmodifiableList() here for clarity;
        // the result of List.copyOf() is unmodifiable by construction, but
        // if we use, e.g., a defensive copy to a (very much modifiable)
        // ArrayList in the constructor, the wrapper here will be needed.
        return Collections.unmodifiableList(this.entries);
    }
}
