package pij.day9solutions.point;

/**
 * Implementation of the geometrical concept of a point in two dimensions.
 * Provides methods to access the coordinates as well as to move a point.
 *<p>
 * Implements Comparable&lt;Point&gt; following Ex 2, item 3: necessary for
 * elements of SortedSet / TreeSet.
 */
public class Point implements Comparable<Point> {
    private int x;
    private int y;

    /**
     * Constructs a new Point with the given coordinates.
     *
     * @param x the x coordinate of the new Point
     * @param y the y coordinate of the new Point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for the x coordinate of this Point.
     *
     * @return the x coordinate of this Point
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for the y coordinate of this Point.
     *
     * @return the y coordinate of this Point
     */
    public int getY() {
        return y;
    }

    /**
     * Changes the coordinates of this Point to be the same as those of remote.
     *
     * @param remote the Point to which we want to move this Point
     */
    public void moveTo(Point remote) {
        this.x = remote.x;
        this.y = remote.y;
    }

    // Ex 2, item 1.
    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Point)) {
            return false;
        }
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }

    // Ex 2, item 2. HashSet and LinkedHashSet require that equal
    // elements have the same hash code.
    @Override
    public int hashCode() {
        // here many options are available
        final int PRIME = 31;
        return this.x + PRIME*this.y;
    }


    @Override
    public int compareTo(Point o) {
        // Ex 2, item 3. Make sure that 0 is returned if and only if
        // this and o are equal

        // (1) If x differs, use it as the criterion.
        if (this.x > o.x) {
            return 1;
        }
        if (this.x < o.x) {
            return -1;
        }

        // (2) So x is the same. Next tie-breaker: y
        if (this.y > o.y) {
            return 1;
        }
        if (this.y < o.y) {
            return -1;
        }

        // (3) Both x and y are the same! So the points are equal.
        return 0;
    }
}
