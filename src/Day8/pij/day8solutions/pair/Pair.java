package pij.day8solutions.pair;

/**
 * A Pair can store two values of possibly different types.
 *
 * @param <X> the type of the first element of the pair
 * @param <Y> the type of the second element of the pair
 */
public class Pair<X, Y> {

    private final X x;
    private final Y y;

    /**
     * Creates a Pair with x and y as elements, in that order.
     *
     * @param x the first element to be stored in the Pair
     * @param y the second element to be stored in the Pair
     */
    public Pair(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Makes a copy of the contents of the constructor parameter.
     *
     * @param other to be copied into this Pair
     */
    public Pair(Pair<X, Y> other) {
        this(other.x, other.y);
    }

    /**
     * Returns the first component of this Pair.
     *
     * @return the first component of this Pair
     */
    public X getX() {
        return this.x;
    }

    /**
     * Returns the second component of this Pair.
     *
     * @return the second component of this Pair
     */
    public Y getY() {
        return this.y;
    }

    /**
     * Returns a swapped version of this Pair, where the first and second
     * component are exchanged.
     *
     * @return a swapped version of this Pair, where the first and second
     *  component are exchanged
     */
    public Pair<Y, X> swap() {
        return new Pair<>(this.y, this.x);
    }
}
