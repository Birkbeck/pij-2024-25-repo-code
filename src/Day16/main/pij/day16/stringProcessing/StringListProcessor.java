package pij.day16.stringProcessing;

import java.util.List;

/**
 * Provides several methods to analyse lists of String objects.
 */
public class StringListProcessor {

    /**
     * Private constructor to prevent that instances of StringListProcessor
     * are created (they are not needed).
     */
    private StringListProcessor() {}

    /**
     * Returns the number of String objects in strings whose length is at least
     * minLength.
     *
     * @param strings the List of String objects to analyse
     * @param minLength the minimum length required for a String to be
     *                  considered "long" by this method
     * @return the number of String objects in strings whose length is at least
     *         minLength
     * @throws NullPointerException if strings is or contains null
     */
    public static long countLongStrings(List<String> strings, int minLength) {
        return strings.stream()
                .filter(s -> s.length() >= minLength)
                .count();
    }

    /**
     * Returns the number of String objects in strings whose length is at least
     * minLength.
     * Implementation note: uses a loop rather than a stream.
     *
     * @param strings the List of String objects to analyse
     * @param minLength the minimum length required for a String to be
     *                  considered "long" by this method
     * @return the number of String objects in strings whose length is at least
     *         minLength
     * @throws NullPointerException if strings is or contains null
     */
    public static long countLongStringsLoop(List<String> strings,
                                            int minLength) {
        int result = 0;
        for (String s : strings) {
            if (s.length() >= minLength) {
                result++;
            }
        }
        return result;
    }

    /**
     * Returns the String objects in strings whose length is at least minLength.
     *
     * @param strings the List of String objects to analyse
     * @param minLength the minimum length required for a String to be
     *                  considered "long" by this method
     * @return the String objects in strings whose length is at least
     *         minLength
     * @throws NullPointerException if strings is or contains null
     */
    public static List<String> getLongStrings(List<String> strings, int minLength) {
        return strings.stream()
                .filter(s -> s.length() >= minLength)
                .toList();
    }

    /**
     * Returns the list of the lengths of the String objects in strings.
     *
     * @param strings the List of String objects to analyse
     * @return the list of the lengths of the String objects in strings
     * @throws NullPointerException if strings is or contains null
     */
    public static List<Integer> getLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
