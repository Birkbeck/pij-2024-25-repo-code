package pij.day16.map;

/**
 * Provides a method that shifts its parameter by a fixed constant.
 * The constant is fixed when the Shifter object is constructed.
 */
public class Shifter {

    /** The value that method shift will add to its argument.  */
    private final int shift;

    /**
     * Constructs a new Shifter with this shift.
     *
     * @param shift value that method shift will add to its argument
     */
    public Shifter(int shift) {
        this.shift = shift;
    }

    /**
     * Shifts a single value using the shift of this Shifter.
     *
     * @param value the value to be shifted
     * @return the given value plus the shift of this Shifter
     */
    public int shift(int value) {
        return value + this.shift;
    }

    /**
     * Returns the shift of this Shifter.
     *
     * @return the shift of this Shifter
     */
    public int getShift() {
        return this.shift;
    }

    @Override
    public String toString() {
        return "Shifter with a shift of: " + this.shift;
    }

    /**
     * Shifts all elements of data using this Shifter and returns the result.
     *
     * @param data to be shifted; not modified by this method
     * @return [this.shift(data[0]), ..., this.shift(data[data.length-1])]
     */
    public int[] shiftAll(int[] data) {
        return ArrayMapper.map(this::shift, data);
    }

    /**
     * Shifts all elements of data using a given Shifter and returns the result.
     *
     * @param s the shifter to use
     * @param data to be shifted; not modified by this method
     * @return [s.shift(data[0]), ..., s.shift(data[data.length-1])]
     */
    public static int[] shiftAll(Shifter s, int[] data) {
        return ArrayMapper.map(s::shift, data);
    }

    /**
     * Sorts the Shifters in the parameter array in-place based on their shift.
     *
     * @param shifters the shifters to sort; will be sorted after the method
     *                 call
     * @throws NullPointerException if shifters is or contains null
     */
    public static void sortShifters(Shifter[] shifters) {
        java.util.Arrays.sort(shifters, (s1, s2) -> s1.getShift() - s2.getShift());
    }
}
