package pij.day16.map;

/**
 * Implementation of IntToIntFunction via a function that multiplies two and
 * its parameter.
 */
public class MultiplyByTwoFunction implements IntToIntFunction {

    /**
     * Multiplies the parameter value with two and returns the result.
     *
     * @param input an int value to be passed to this IntToIntFunction
     * @return two times the parameter value
     */
    @Override
    public int apply(int input) {
        return 2 * input;
    }
}
