package pij.day13solution.power;

/**
 * Direct implementations of the definition of the power function on int.
 * Here 0 to the power of 0 is defined to be 1.
 */
public class Power {

    /**
     * Returns base to the power of exponent.
     * Unoptimised recursive implementation.
     *
     * @param base the base of the power operation
     * @param exponent the exponent of the power operation
     * @return base to the power of exponent
     * @throws IllegalArgumentException if exponent is negative
     */
    public static long powRecursive(int base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent must not be negative, found "
                + exponent);
        }
        if (exponent == 0) {
            return 1;
        }
        return base * powRecursive(base, exponent - 1);
    }

    /**
     * Returns base to the power of exponent.
     * Unoptimised iterative implementation.
     *
     * @param base the base of the power operation
     * @param exponent the exponent of the power operation
     * @return base to the power of exponent
     * @throws IllegalArgumentException if exponent is negative
     */
    public static long powIterative(int base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent must not be negative, found "
                    + exponent);
        }
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}
