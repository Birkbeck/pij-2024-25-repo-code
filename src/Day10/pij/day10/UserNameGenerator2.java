package pij.day10;

/**
 * Provides a method to generate a username. Second attempt -- can also
 * deal with short surnames.
 */
public class UserNameGenerator2 {
    /**
     * The first SURNAME_PREFIX_LENGTH letters of the surname shall
     * be used for the username generation.
     */
    public static int SURNAME_PREFIX_LENGTH = 5;
    /**
     * Generates a username with initial followed by the first SURNAME_PREFIX_LENGTH
     * letters of surname, or the full surname, whichever is shorter.
     *
     * @param initial the first character of the new username
     * @param surname the source of the remainder of the new username
     * @return a username with initial followed by the first SURNAME_PREFIX_LENGTH
     *  letters of surname, or the full surname, whichever is shorter
     * @throws NullPointerException if surname is the null reference
     */
    public String generateUsername(char initial, String surname) {
        int endIndex = SURNAME_PREFIX_LENGTH;
        if (surname.length() < endIndex) {
            endIndex = surname.length();
        }
        return initial + surname.substring(0, endIndex);
    }
}
