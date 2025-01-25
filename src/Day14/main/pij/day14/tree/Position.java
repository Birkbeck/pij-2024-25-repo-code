package pij.day14.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


/**
 * A position describes a particular location in a tree via a sequence
 * of Directions from the root.
 * <p>
 * For instance, a position [RIGHT, LEFT] is reached from the root
 * of a tree we first need to go to the right subtree and then to the
 * left subtree. So for the tree
 * <pre>
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * </pre>
 * the value at position [RIGHT, LEFT] is 4.
 */
public class Position {
    /** The list of directions to represent a position in a tree,
     *  where a low index indicates that the node is close to the
     *  root of the tree. May neither be nor contain null.
     */
    private final List<Direction> directions;

    /**
     * Constructs an empty Position (with size 0), corresponding to the root
     * of a Tree.
     */
    public Position() {
        this(Collections.emptyList());
    }

    /**
     * Constructs a Position corresponding to directions.
     *
     * @param directions indicates the Directions this Position will represent;
     *                   may be modified after the constructor call without
     *                   affecting this Position
     * @throws NullPointerException if directions is null or contains null
     */
    public Position(List<Direction> directions) {
        sanityCheck(directions);
        this.directions = new ArrayList<>(directions);
    }

    private static void sanityCheck(List<Direction> directions) {
        for (Direction d : directions) {
            Objects.requireNonNull(d, "Direction must not be null!");
        }
    }

    /**
     * @return the number of Directions in this Position
     */
    public int size() {
        return this.directions.size();
    }

    /**
     * @param index we want the Direction indicated for the index;
     *              0 <= i < this.size() must hold
     * @return the Direction indicated at index i
     */
    public Direction get(int index) {
        return this.directions.get(index);
    }

    /**
     * Creates a Position for the suffix of this Position starting at fromIndex.
     *
     * @param fromIndex the starting index for the new Position
     * @return a Position for the suffix of this Position starting at fromIndex
     * @throws IllegalArgumentException if fromIndex < 0 or fromIndex > this.size()
     */
    public Position createPositionFrom(int fromIndex) {
        if (fromIndex < 0 || fromIndex > this.size()) {
            throw new IllegalArgumentException();
        }
        return new Position(this.directions.subList(fromIndex, this.directions.size()));
    }

    /**
     * @return a String representation of this Position
     */
    @Override
    public String toString() {
        return this.directions.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return Objects.equals(this.directions, position.directions);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.directions);
    }

}
