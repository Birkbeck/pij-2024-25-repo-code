package pij.day14.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * A node for a generic binary tree with a data element and
 * two pointers to the left and right child node.
 *
 * @param <E> the type of elements in the node
 */
public class TreeNode<E> {
    /** The data object stored in this TreeNode<E>. May be null. */
    private E data;

    /** Reference to the left subtree. May be null. */
    private TreeNode<E> left;

    /** Reference to the right subtree. May be null. */
    private TreeNode<E> right;

    /**
     * Initialises a new TreeNode<E> using the parameter values.
     *
     * @param data reference to the data object to store in this TreeNode<E>
     * @param left reference to the left subtree
     * @param right reference to the right subtree
     */
    public TreeNode(E data, TreeNode<E> left, TreeNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * Initialises a new TreeNode<E> that has no left subtree and no right
     * subtree (a "leaf node").
     *
     * @param data reference to the data object to store in this TreeNode<E>
     */
    public TreeNode(E data) {
        this(data, null, null);
    }

    /**
     * Prints this TreeNode<E> and its subtrees on the screen using
     * recursive pre-order traversal.
     */
    public void printTreePreOrder() {
        System.out.println(this.data);
        if (this.left != null) {
            this.left.printTreePreOrder();
        }
        if (this.right != null) {
            this.right.printTreePreOrder();
        }
    }

    /**
     * Prints this TreeNode<E> and its subtrees on the screen using
     * recursive in-order traversal.
     */
    public void printTreeInOrder() {
        if (this.left != null) {
            this.left.printTreeInOrder();
        }
        System.out.println(this.data);
        if (this.right != null) {
            this.right.printTreeInOrder();
        }
    }

    /**
     * Prints this TreeNode<E> and its subtrees on the screen using
     * recursive post-order traversal.
     */
    public void printTreePostOrder() {
        if (this.left != null) {
            this.left.printTreePostOrder();
        }
        if (this.right != null) {
            this.right.printTreePostOrder();
        }
        System.out.println(this.data);
    }

    /**
     * Prints this TreeNode<E> and its subtrees on the screen using
     * iterative pre-order traversal with an explicit stack.
     */
    public void printTreePreOrderLoop() {
        Deque<TreeNode<E>> stack = new LinkedList<>();
        stack.push(this);
        while (!stack.isEmpty()) {
            TreeNode<E> node = stack.pop();

            System.out.println(node.data);
            // first push the Node that is to be visited /later/
            if (node.right != null) {
                stack.push(node.right);
            }
            // then push the Node to stack that is to be visited
            // /earlier/ (top-of-stack is popped next)
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
