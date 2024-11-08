package pij.day13.triangle;

/**
 * Class to represent triangles of a certain width.
 */
public class Triangle {
    /** The width of the Triangle. At least 1. */
    private final int width;

    /**
     * Constructs a new Triangle with a given width.
     *
     * @param width  the width of the Triangle, at least 1
     * @throws IllegalArgumentException if width is less than 1
     */
    public Triangle(int width) {
        if (width < 1) {
            throw new IllegalArgumentException(
                    "width of at least 1 expected, found: " + width);
        }
        this.width = width;
    }

    /**
     * @return the area of the Triangle
     */
    public int getArea() {
        if (this.width == 1) {
            return 1;
        }
        Triangle smallerTriangle = new Triangle(this.width - 1);
        return smallerTriangle.getArea() + this.width;
    }
}
