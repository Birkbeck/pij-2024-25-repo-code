package pij.day15.graph;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * A node in a directed graph with edges to nodes. Every node stores
 * a reference to a data object.
 *
 * @param <E> the type of the data objects stored in the node
 */
public class Node<E> {
    /**
     * The data object stored in this Node<E>.
     */
    private final E data;

    /**
     *  Contains the successors of this Node<E> in the graph.
     *  Must not be null nor contain null.
     */
    private final Set<Node<E>> successors;

    /**
     * Constructs a new Node<E> storing <code>data</code>. The node initially
     * has no successors.
     *
     * @param data the reference to store in this node
     */
    public Node(E data) {
        this.data = data;
        this.successors = new LinkedHashSet<>();
    }

    /**
     * Adds an edge to a given node object.
     *
     * @param dest the node to which we want to add an edge
     * @return whether the edge was newly added by this method call
     * @throws NullPointerException if dest is null
     */
    public boolean addEdgeTo(Node<E> dest) {
        return this.successors.add(Objects.requireNonNull(dest));
    }

    /**
     * Returns the data stored in this Node<E>.
     *
     * @return the data stored in this Node<E>
     */
    public E getData() {
        return this.data;
    }
}
