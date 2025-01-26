package pij.day13solution.reverse;

/**
 * Unoptimised recursive implementation of a method to reverse a String.
 */
public class Reverse {

    /**
     * Returns the reverse of s. For example, the reverse of "abcd" is "dcba".
     *
     * @param s the String to reverse
     * @return the reverse of s
     * @throws IllegalArgumentException if s is nul
     */
    public static String reverse(String s) {
        // base case
        if (s.length() <= 1) {
            return s;
        }

        // recursive case: at least length 2

        // all elements from index 1 to the end
        String smaller = s.substring(1);

        // smallerSolution is the reverse of the String smaller
        String smallerSolution = reverse(smaller);

        // the first character of s goes after smallerSolution
        // to make the solution for s
        String solution = smallerSolution + s.charAt(0);
        return solution;
    }
}
