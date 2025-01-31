package pij.day15solution.expression;

/**
 * Represents an IntExpression of the form (e1 * e2).
 */
public class TimesExpression extends BinaryExpression {

    /** Operator symbol for a TimesExpression. */
    private static final String OPERATOR_SYMBOL = "*";

    /**
     * Constructs a TimesExpression with left and right as direct
     * subexpressions.
     *
     * @param left the left subexpression
     * @param right the right subexpression
     * @throws NullPointerException if left or right is null
     */
    public TimesExpression(IntExpression left, IntExpression right) {
        super(left, right, OPERATOR_SYMBOL);
    }

    /**
     * @return the product of the values of the direct subexpressions
     */
    @Override
    public int value() {
        return this.getLeft().value() * this.getRight().value();
    }
}
