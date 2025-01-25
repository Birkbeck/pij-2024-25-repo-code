package pij.day14solution.tree;

import pij.day14.tree.Position;

import java.util.Collection;
import java.util.Objects;

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

    /**
     * Returns whether this Tree contains o as data.
     *
     * @param o to be found in this Tree
     * @return whether this Tree contains o as data
     */
    public boolean contains(Object o) {
        if (this.root == null) {
            return false;
        }
        return this.root.contains(o);
    }

    @Override
    public String toString() {
        if (this.root == null) {
            return "[]";
        }
        return this.root.toString();
    }

    /**
     * Returns a simplified String representation of this Tree,
     * omitting empty subtrees below the root.
     *
     * @return a simplified String representation of this Tree,
     *  omitting empty subtrees below the root
     */
    public String toStringSimplified() {
        if (this.root == null) {
            return "[]";
        }
        return this.root.toStringSimplified();
    }

    /**
     * Returns the height of the tree with this TreeNode as root.
     * For a non-empty tree, its height is defined as the length
     * of the longest path to a leaf node.
     * For an empty tree, the method returns -1.
     *
     * @return the height of the tree with this TreeNode as root
     */
    public int height() {
        if (this.root == null) {
            return -1;
        }
        return this.root.height();
    }

    /**
     * Returns the number of TreeNodes in this Tree.
     *
     * @return the number of TreeNodes in this Tree
     */
    public int size() {
        if (this.root == null) {
            return 0;
        }
        return this.root.size();
    }

    /**
     * Adds all data elements in the tree with this TreeNode as root to c.
     * Does so in pre-order: first add in the left subtree, then locally,
     * then in the right subtree.
     *
     * @param c data from this tree shall be added here as side effect
     * @throws NullPointerException if c is null and this tree is not empty
     */
    public void collect(Collection<E> c) {
        if (this.root == null) {
            return;
        }
        this.root.collect(c);
    }

    /**
     * Returns whether this tree has the position indicated by p.
     *
     * @param p the position that may or may not be in this tree
     * @return whether this tree has the position indicated by p
     * @throws NullPointerException if p is null and this tree is not empty
     */
    public boolean hasPosition(Position p) {
        if (this.root == null) {
            return false; // the empty tree has no positions
        }
        return this.root.hasPosition(p);
    }

    /**
     * Returns the data element stored in this tree at position p.
     *
     * @param p the position from which we want to get data in this tree
     * @return the data element stored in this tree at position p
     * @throws NullPointerException if p is null
     * @throws IllegalArgumentException if this tree does not have position p
     */
    public E get(Position p) {
        if (this.root == null) {
            throw new IllegalArgumentException("The empty tree has no positions!");
        }
        return this.root.get(p);
    }

    /**
     * Returns the leftmost position in this tree where the data object is
     * equal to findMe.
     *
     * @param findMe we want its leftmost position in the tree
     * @return the leftmost position in this tree where the data object is
     *  equal to findMe
     */
    public Position positionOf(Object findMe) {
        if (this.root == null) {
            return null; // the empty tree has no data
        }
        return this.root.positionOf(findMe);
    }

    /**
     * Replaces the data at position p by newData.
     *
     * @param p the position at which to insert
     * @param newData the replacement data reference
     * @return the old data reference found at p
     * @throws NullPointerException if p is null
     * @throws IllegalArgumentException if p is not a position of this tree
     */
    public E replaceData(Position p, E newData) {
        if (this.root == null) {
            throw new IllegalArgumentException("The empty tree has no data to replace!");
        }
        return this.root.replaceData(p, newData);
    }

    /**
     * Inserts a new subtree into this tree at position p if this is possible.
     *
     * @param p the position at which to replace
     * @param replacement the replacement subtree
     * @return the data object that was stored at position p, or null if there
     *  is no such object (the spec was unclear on the intended return value)
     * @throws NullPointerException if p is null
     * @throws IllegalArgumentException if this tree does not have p without
     *  its last element (if any) as a position
     */
    public E insertSubtree(Position p, TreeNode<E> replacement) {
        if (p.size() == 0) {
            E result = this.root.get(p);
            this.root = replacement;
            return result;
        }
        return this.root.insertSubtree(p, replacement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Tree<?> tree = (Tree<?>) o;
        return Objects.equals(this.root, tree.root);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.root);
    }
}
