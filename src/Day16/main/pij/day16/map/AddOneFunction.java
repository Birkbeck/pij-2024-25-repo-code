package pij.day16.map;

/**
 * Implementation of IntToIntFunction via a function that adds one to
 * its parameter.
 */
public class AddOneFunction implements IntToIntFunction {
    @Override
    public int apply(int input) {
        return input + 1;
    }
}
