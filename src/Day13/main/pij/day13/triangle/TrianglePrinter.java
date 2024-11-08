package pij.day13.triangle;

/**
 * Class with a static method to print a Triangle on the screen. 
 */
public class TrianglePrinter {

    /**
     * Prints a Triangle of length sideLength on the screen.
     * Does nothing if sideLength is zero or negative.
     *
     * @param sideLength  the length of the triangle to print
     */
    public static void printTriangle(int sideLength) {
        if (sideLength <= 0) {
            return;
        }
        printTriangle(sideLength - 1);
        for (int i = 0; i < sideLength; i++) {
            System.out.print("[]");
        }
        System.out.println();
    }

    /**
     * Driver method to test printTriangle.
     * @param args  ignored
     */
    public static void main(String[] args) {
        printTriangle(4);
    }
}
