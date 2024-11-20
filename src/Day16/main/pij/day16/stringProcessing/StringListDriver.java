package pij.day16.stringProcessing;

import java.util.List;

/**
 * Driver class for StringListProcessor to exercise its methods.
 */
public class StringListDriver {

    public static void main(String[] args) {
        final int MIN_LENGTH = 4;
        List<String> inputs = List.of("Alice", "Bob", "Birkbeck", "Celia");
        System.out.println("inputs: " + inputs);
        System.out.println("Strings of length " + MIN_LENGTH + " or more: "
                + StringListProcessor.getLongStrings(inputs, MIN_LENGTH));
        System.out.println("Number of strings of length " + MIN_LENGTH + " or more: "
                + StringListProcessor.countLongStrings(inputs, MIN_LENGTH));
        System.out.println("Number of strings of length " + MIN_LENGTH + " or more (counted via loop): "
                + StringListProcessor.countLongStringsLoop(inputs, MIN_LENGTH));
        System.out.println("Lengths of all strings: "
                + StringListProcessor.getLengths(inputs));
    }
}
