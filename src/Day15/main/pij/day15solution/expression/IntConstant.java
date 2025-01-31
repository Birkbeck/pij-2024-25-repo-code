package pij.day15solution.expression;

/**
 * IntExpression that represents an int value.
 */
public class IntConstant implements IntExpression {

    /** stores the encapsulated value */
    private int value;

    /**
     * Constructs a new IntConstant encapsulating value.
     *
     * @param value to be encapsulated in this IntConstant
     */
    public IntConstant(int value) {
        this.value = value;
    }

    /**
     * @return the int value this IntConstant stands for
     */
    @Override
    public int value() {
        return this.value;
    }

    /**
     * @return the number of nodes of this IntConstant (always 1)
     */
    @Override
    public int numberOfNodes() {
        return 1;
    }

    @Override
    public String toString() {
        return "" + this.value;
    }
}
