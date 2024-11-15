package pij.day15.expression;

/**
 * Represents an IntExpression of the form (e1 + e2).
 */
public class PlusExpression extends BinaryExpression {

    /**
     * Constructs a PlusExpression with left and right as direct
     * subexpressions.
     *
     * @param left the left subexpression
     * @param right the right subexpression
     * @throws NullPointerException if left or right is null
     */
    public PlusExpression(IntExpression left, IntExpression right) {
        super(left, right);
    }

    /**
     * @return the sum of the values of the direct subexpressions
     */
    @Override
    public int value() {
        return this.getLeft().value() + this.getRight().value();
    }
}
