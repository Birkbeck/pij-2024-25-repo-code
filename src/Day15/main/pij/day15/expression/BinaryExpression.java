package pij.day15.expression;

import java.util.Objects;

/**
 * Abstract class for IntExpressions with two direct subexpressions.
 * Provides an implementation for numberOfNodes() method.
 */
public abstract class BinaryExpression implements IntExpression {

    /** the left subexpression; non-null */
    private IntExpression left;

    /** the right subexpression; non-null */
    private IntExpression right;

    /**
     * Constructs a BinaryExpression with left and right as direct
     * subexpressions.
     *
     * @param left the left subexpression
     * @param right the right subexpression
     * @throws NullPointerException if left or right is null
     */
    public BinaryExpression(IntExpression left, IntExpression right) {
        this.left = Objects.requireNonNull(left, "Illegal null IntExpression!");
        this.right = Objects.requireNonNull(right, "Illegal null IntExpression!");
    }

    /**
     * Getter for the left subexpression.
     *
     * @return the left subexpression
     */
    public IntExpression getLeft() {
        return this.left;
    }

    /**
     * Getter for the right subexpression.
     *
     * @return the right subexpression
     */
    public IntExpression getRight() {
        return this.right;
    }

    /**
     * The number of nodes of a BinaryExpression is 1 plus the number of
     * nodes of the left subexpression and of the right subexpression.
     *
     * @return the number of nodes of this expression
     */
    @Override
    public int numberOfNodes() {
        return 1 + this.left.numberOfNodes() + this.right.numberOfNodes();
    }
}
