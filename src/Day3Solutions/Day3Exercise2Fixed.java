/**
 * This program compares two expressions of type double that would have
 * the same value if they were real numbers, but actually have slightly
 * different values. It checks whether these values are "close enough"
 * to each other. It prints this observation to the user.
 */
public class Day3Exercise2Fixed {
    public static void main(String[] args) {
        double d1 = 1.255;
        double d2 = d1 + 7 - 4 - 3;
        double delta = 10E-6; // below this "distance", we consider the values to be "equal"
        if (Math.abs(d1 - d2) < delta) {
            System.out.println("1.255 is approximately equal to 1.255 plus 7 minus 7");
        } else {
            System.out.println("1.255 is NOT approximately equal to 1.255 plus 7 minus 7");
        }
    }
}
