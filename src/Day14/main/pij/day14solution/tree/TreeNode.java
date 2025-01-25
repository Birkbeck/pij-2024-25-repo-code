package pij.day14solution.tree;

import pij.day14.tree.Direction;
import pij.day14.tree.Position;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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

    /**
     * Returns whether o is stored as data in some TreeNode of the tree that
     * has this TreeNode as root.
     *
     * @param o to be found in the tree
     * @return whether o is stored as data in some TreeNode of the tree that
     *  has this TreeNode as root
     */
    public boolean contains(Object o) {
        if (Objects.equals(this.data, o)) {
            return true;
        }
        if (this.left != null && this.left.contains(o)) {
            return true;
        }
        if (this.right != null && this.right.contains(o)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(this.data);
        sb.append(" L");
        sb.append(nodeToString(this.left));
        sb.append(" R");
        sb.append(nodeToString(this.right));
        sb.append(']');
        return sb.toString();
    }

    /**
     * Private helper method for recursive toString(), graceful on null
     * references as parameter values.
     *
     * @param subtreeOrNull to be exported to String
     * @return a String representation for the parameter
     */
    private static String nodeToString(TreeNode<?> subtreeOrNull) {
        return (subtreeOrNull == null) ? "[]" : subtreeOrNull.toString();
    }

    /**
     * Returns a simplified String representation of the tree
     * with this TreeNode as root, omitting empty subtrees.
     *
     * @return a simplified String representation of the tree
     *  with this TreeNode as root, omitting empty subtrees
     */
    public String toStringSimplified() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(this.data);
        if (this.left != null) {
            sb.append(' ');
            sb.append(this.left.toStringSimplified());
        }
        if (this.right != null) {
            sb.append(' ');
            sb.append(this.right.toStringSimplified());
        }
        sb.append(']');
        return sb.toString();
    }

    /**
     * Returns the height of the tree with this TreeNode as root.
     * For a non-empty tree, its height is defined as the length
     * of the longest path to a leaf node.
     *
     * @return the height of the tree with this TreeNode as root
     */
    public int height() {
        int result = 0;
        if (this.left != null) {
            result = 1 + this.left.height();
        }
        if (this.right != null) {
            result = Math.max(result, 1 + this.right.height());
        }
        return result;
    }

    /**
     * Returns the number of TreeNodes reachable from this TreeNode.
     *
     * @return the number of TreeNodes reachable from this TreeNode
     */
    public int size() {
        int result = 1; // this TreeNode alone contributes 1
        if (this.left != null) {
            result += this.left.size();
        }
        if (this.right != null) {
            result += this.right.size();
        }
        return result;
    }

    /**
     * Adds all data elements in the tree with this TreeNode as root to c.
     * Does so in-order: first add in the left subtree, then locally,
     * then in the right subtree.
     *
     * @param c data from this tree shall be added here as side effect
     * @throws NullPointerException if c is null
     */
    public void collect(Collection<E> c) {
        if (this.left != null) {
            this.left.collect(c);
        }
        c.add(this.data);
        if (this.right != null) {
            this.right.collect(c);
        }
    }

    /**
     * Returns the node at position p in this tree.
     *
     * @param p a position from which we want to retrieve the node
     * @return the node at position p in this tree
     * @throws NullPointerException if p is null
     * @throws IllegalArgumentException if p is not a position in this tree
     */
    private TreeNode<E> getNodeAt(Position p) {
        if (p.size() == 0) {
            return this;
        }
        Direction dir = p.get(0);
        Position smallerPosition = p.createPositionFrom(1);
        switch (dir) {
            // an if statement or an "enhanced switch statement" are
            // alternatives here
            case LEFT:
                if (this.left == null) {
                    throw new IllegalArgumentException("Reached end of path, remaining position is "
                            + smallerPosition);
                }
                return this.left.getNodeAt(smallerPosition);
                // no break; right after return
            case RIGHT:
                if (this.right == null) {
                    throw new IllegalArgumentException("Reached end of path, remaining position is "
                            + smallerPosition);
                }
                return this.right.getNodeAt(smallerPosition);
            default:
                // If someone has added another entry to enum Direction
                // in the meantime, this code will have to be revisited.
                throw new RuntimeException("Unknown direction " + dir + "!");
        }
    }

    /**
     * Returns whether this tree has the position indicated by p.
     *
     * @param p the position that may or may not be in this tree
     * @return whether this tree has the position indicated by p
     * @throws NullPointerException if p is null
     */
    public boolean hasPosition(Position p) {
        if (p.size() == 0) { // empty position for the root
            return true;
        }
        Direction dir = p.get(0);
        Position smallerPosition = p.createPositionFrom(1);
        switch (dir) {
            // an if statement or an "enhanced switch statement" are
            // alternatives here
            case LEFT:
                if (this.left == null) {
                    return false;
                }
                // check left subtree for smaller position
                return this.left.hasPosition(smallerPosition);
                // no break; right after return
            case RIGHT:
                if (this.right == null) {
                    return false;
                }
                return this.right.hasPosition(smallerPosition);
            default:
                // If someone has added another entry to enum Direction
                // in the meantime, this code will have to be revisited.
                throw new RuntimeException("Unknown direction " + dir + "!");
        }
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
        TreeNode<E> nodeAtPosition = this.getNodeAt(p);
        return nodeAtPosition.data;
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
        return this.positionOf(findMe, new ArrayList<>());
    }

    /**
     * Returns the concatenation of positionBuilder and the leftmost position
     * in this tree where the data object is equal to findMe. Recursive helper
     * method.
     *
     * @param findMe we want its leftmost position in the tree
     * @param positionBuilder the position of this TreeNode in the overall tree,
     *                        will be modified
     * @return the concatenation of positionBuilder and the leftmost position
     *  in this tree where the data object is equal to findMe
     * @throws NullPointerException if positionBuilder is null or contains null
     */
    private Position positionOf(Object findMe, List<Direction> positionBuilder) {
        // First look on the left ...
        if (this.left != null) {
            positionBuilder.addLast(Direction.LEFT);
            Position leftPos = this.left.positionOf(findMe, positionBuilder);
            if (leftPos != null) {
                return new Position(positionBuilder);
            }
            positionBuilder.removeLast(); // undo the addition, nothing to find here
        }

        // ... then look locally ...
        if (Objects.equals(this.data, findMe)) {
            // found it!
            return new Position(positionBuilder);
        }

        // ... and now look on the right
        if (this.right != null) {
            positionBuilder.addLast(Direction.RIGHT);
            Position rightPos = this.right.positionOf(findMe, positionBuilder);
            if (rightPos != null) {
                return new Position(positionBuilder);
            }
            positionBuilder.removeLast(); // undo the addition, nothing to find here
        }

        // Still nothing? Then findMe is not in the tree.
        return null;

        // Here we reuse the same positionBuilder object, which always stores
        // the current position in the overall tree. An alternative (but less
        // efficient) solution would be to create new List<Direction> objects
        // with this information for each recursive call.
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
        TreeNode<E> nodeAtPosition = this.getNodeAt(p);
        E result = nodeAtPosition.data;
        nodeAtPosition.data = newData;
        return result;
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
     *  its last element (if any) as a position or if p has size 0
     */
    public E insertSubtree(Position p, TreeNode<E> replacement) {
        int pSize = p.size();
        if (pSize == 0) {
            throw new IllegalArgumentException("Position of size 0 not allowed here!");
        }
        Direction dir = p.get(0);
        if (pSize == 1) { // insert here!
            E result = null;
            switch (dir) {
                case LEFT:
                    if (this.left != null) {
                        result = this.left.data;
                    }
                    this.left = replacement;
                    break;
                case RIGHT:
                    if (this.right != null) {
                        result = this.right.data;
                    }
                    this.right = replacement;
                    break;
                default:
                    // If someone has added another entry to enum Direction
                    // in the meantime, this code will have to be revisited.
                    throw new RuntimeException("Unknown direction " + dir + "!");
            }
            return result;
        }
        // pSize >= 2, so we need to check with the corresponding child node
        Position smallerPosition = p.createPositionFrom(1);
        switch (dir) {
            case LEFT:
                if (this.left == null) {
                    throw new IllegalArgumentException("Remaining path empty, but remaining position is "
                            + smallerPosition);
                }
                return this.left.insertSubtree(smallerPosition, replacement);
            case RIGHT:
                if (this.right == null) {
                    throw new IllegalArgumentException("Remaining path empty, but remaining position is "
                            + smallerPosition);
                }
                return this.right.insertSubtree(smallerPosition, replacement);
            default:
                // If someone has added another entry to enum Direction
                // in the meantime, this code will have to be revisited.
                throw new RuntimeException("Unknown direction " + dir + "!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        TreeNode<?> treeNode = (TreeNode<?>) o;
        return Objects.equals(this.data, treeNode.data)
                && Objects.equals(this.left, treeNode.left)
                && Objects.equals(this.right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.data, this.left, this.right);
    }
}
