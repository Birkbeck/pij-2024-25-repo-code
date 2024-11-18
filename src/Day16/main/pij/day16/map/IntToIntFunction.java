package pij.day16.map;

/**
 * Functional interface for a function that takes an int as parameter
 * and returns an int.
 */
public interface IntToIntFunction {

    /**
     * An arbitrary function from int to int.
     *
     * @param input an int value to be passed to this IntToIntFunction
     * @return the result of applying this IntToIntFunction to input
     */
    int apply(int input);
}
