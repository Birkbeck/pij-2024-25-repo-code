package pij.day10;

/**
 * Provides a method to generate a username. First attempt -- will not work
 * correctly if the surname is shorter than expected!
 */
public class UserNameGenerator {
    /**
     * The first SURNAME_PREFIX_LENGTH letters of the surname shall
     * be used for the username generation.
     */
    public static int SURNAME_PREFIX_LENGTH = 5;
    /**
     * Generates a username with initial followed by the first
     * SURNAME_PREFIX_LENGTH letters of surname.
     *
     * @param initial the first character of the new username
     * @param surname the source of the remainder of the new username
     * @return a username with initial followed by the first
     *  SURNAME_PREFIX_LENGTH letters of surname.
     * @throws NullPointerException if surname is the null reference
     */
    public String generateUsername(char initial, String surname) {
        return initial + surname.substring(0, SURNAME_PREFIX_LENGTH);
    }
}
