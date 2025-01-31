package pij.day15solution.expression;

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

    /** the operator symbol; non-null */
    private String operatorSymbol;

    /**
     * Constructs a BinaryExpression with left and right as direct
     * subexpressions.
     *
     * @param left the left subexpression
     * @param right the right subexpression
     * @param operatorSymbol the operator symbol for the String representation
     * @throws NullPointerException if left or right is null
     */
    public BinaryExpression(IntExpression left, IntExpression right, String operatorSymbol) {
        this.left = Objects.requireNonNull(left, "Illegal null IntExpression!");
        this.right = Objects.requireNonNull(right, "Illegal null IntExpression!");
        this.operatorSymbol = Objects.requireNonNull(operatorSymbol, "Illegal null String!");
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

    @Override
    public String toString() {
        return "(" + this.left.toString() + " " + this.operatorSymbol
                + " " + this.right.toString() + ")";
    }
}
