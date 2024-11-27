package pij.day18solutions.restaurant;

import java.util.Objects;

/**
 * Immutable class to represent a meal with a given name.
 */
public final class Meal {

    /** The name of the meal. */
    private final String name;

    /**
     * Initialises a new Meal with a given name.
     *
     * @param name the name of the meal
     * @throws NullPointerException if name is null
     */
    public Meal(String name) {
        this.name = Objects.requireNonNull(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
