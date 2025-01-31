package pij.day15solution.expression;

/**
 * Represents an IntExpression of the form (e1 / e2).
 * (No changes at all were needed to the existing code when DivExpression
 * was introduced!)
 */
public class DivExpression extends BinaryExpression {

    /** Operator symbol for a DivExpression. */
    private static final String OPERATOR_SYMBOL = "/";

    /**
     * Constructs a DivExpression with left and right as direct
     * subexpressions.
     *
     * @param left the left subexpression
     * @param right the right subexpression
     * @throws NullPointerException if left or right is null
     */
    public DivExpression(IntExpression left, IntExpression right) {
        super(left, right, OPERATOR_SYMBOL);
    }

    /**
     * @return the result of integer division of the values of the direct subexpressions
     */
    @Override
    public int value() {
        return this.getLeft().value() / this.getRight().value();
    }
}
