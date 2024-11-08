package pij.day14.tree;

/**
 * Tree<E> objects are (possibly empty) binary trees. All their nodes can store
 * a reference to an object of type E as payload.
 *
 * @param <E> the type of the elements in this tree
 */
public class Tree<E> {
    /** The root node of the tree. Null means that this is an empty tree. */
    private TreeNode<E> root;

    /**
     * Initialises a new Tree<E> with root as its root node. Here root may be
     * null, for the empty tree.
     *
     * @param root the root node of the new Tree
     */
    public Tree(TreeNode<E> root) {
        this.root = root;
    }

    /**
     * Initialises an empty Tree<E>.
     */
    public Tree() {
        this(null);
    }

    /**
     * Prints this Tree<E> on the screen using recursive pre-order traversal.
     */
    public void printTreePreOrder() {
        if (this.root != null) {
            this.root.printTreePreOrder();
        }
    }

    /**
     * Prints this Tree<E> on the screen using recursive in-order traversal.
     */
    public void printTreeInOrder() {
        if (this.root != null) {
            this.root.printTreeInOrder();
        }
    }

    /**
     * Prints this Tree<E> on the screen using recursive post-order traversal.
     */
    public void printTreePostOrder() {
        if (this.root != null) {
            this.root.printTreePostOrder();
        }
    }

    /**
     * Prints this Tree<E> on the screen using iterative pre-order traversal
     * with an explicit stack.
     */
    public void printTreePreOrderLoop() {
        if (this.root != null) {
            this.root.printTreePreOrderLoop();
        }
    }
}
