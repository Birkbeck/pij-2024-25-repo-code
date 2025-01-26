package pij.day13.triangle;

/**
 * Class with a static method to print a Triangle on the screen. 
 */
public class TrianglePrinter {

    /**
     * Prints a Triangle of length sideLength on the screen.
     * Does nothing if sideLength is zero or negative.
     * Uses recursion.
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
     * Prints a Triangle of length sideLength on the screen.
     * Does nothing if sideLength is zero or negative.
     * Does not use recursion.
     *
     * @param sideLength  the length of the triangle to print
     */
    public static void printTriangleLoopsOnly(int sideLength) {
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("[]");
            }
            System.out.println();
        }
    }

    /**
     * Driver method to test printTriangle.
     * @param args  ignored
     */
    public static void main(String[] args) {
        System.out.println("With recursion:");
        printTriangle(4);
        System.out.println();
        System.out.println("Without recursion:");
        printTriangleLoopsOnly(4);
    }
}
