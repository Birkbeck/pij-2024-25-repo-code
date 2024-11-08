package pij.day13.triangle;

/**
 * Driver class to exercise class Triangle.
 */
public class TriangleDriver {

    /**
     * Creates a Triangle, computes its area, and prints the area
     * on the screen.
     *
     * @param args ignored.
     */
    public static void main(String[] args) {
        Triangle t = new Triangle(4);
        int area = t.getArea();
        System.out.println("Triangle has area " + area);
    }
}
