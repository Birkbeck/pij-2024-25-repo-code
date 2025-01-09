/**
 * This program compares two expressions of type double that would have
 * the same value if they were real numbers, but actually have slightly
 * different values. It prints this observation to the user.
 *
 * It demonstrates that the type double does not represent the real numbers
 * and their standard arithmetic operations, but only approximates them.
 */
public class Day3Exercise2 {
    public static void main(String[] args) {
        double d1 = 1.255;
        double d2 = d1 + 7 - 4 - 3;
        if (d1 == d2) {
            System.out.println("1.255 is equal to 1.255 plus 7 minus 7");
        } else {
            System.out.println("1.255 is NOT equal to 1.255 plus 7 minus 7");
        }
    }
}
