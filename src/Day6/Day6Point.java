/**
 * Implementation of the geometrical concept of a point in two dimensions.
 * Provides methods to access the coordinates as well as to move a point.
 */
public class Day6Point {
    private int x;
    private int y;

    /**
     * Constructs a new Point with the given coordinates.
     *
     * @param x the x coordinate of the new Point
     * @param y the y coordinate of the new Point
     */
    public Day6Point(int x, int y) {
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
    public void moveTo(Day6Point remote) {
        this.x = remote.x;
        this.y = remote.y;
    }
}
