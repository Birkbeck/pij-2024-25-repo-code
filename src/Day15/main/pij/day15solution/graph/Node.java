package pij.day15solution.graph;

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
     * Returns 0 if visited contains this Node, the number of nodes that can be
     * reached from this Node without visiting any Node in visited otherwise.
     *
     * @param visited the Nodes that are considered to have been visited;
     *                all Nodes visited by this method will be added here
     * @return 0 if visited contains this Node, the number of nodes that can be
     *  reached from this Node without visiting any Node in visited otherwise
     * @throws NullPointerException if visited is null
     */
    public int size(Set<Node<E>> visited) {
        if (visited.contains(this)) { // we have counted this Node<E> before
            return 0;
        }
        visited.add(this); // we shall not count this Node<E> again
        int result = 1; // for this Node<E> object
        for (Node<E> successor : this.successors) {
            result += successor.size(visited);
        }
        return result;
    }

    /**
     * Collects data objects at Nodes reachable from this Node that have
     * not yet been visited.
     *
     * @param dataList list of data objects in Nodes reachable from this Node
     *                 without visiting Nodes in visited; will be updated by
     *                 the method call
     * @param visited the Nodes that are considered to have been visited;
     *                all Nodes visited by this method will be added here
     * @throws NullPointerException if dataList or visited is null
     */
    public void collectData(List<E> dataList, Set<Node<E>> visited) {
        if (visited.contains(this)) { // we have been here before
            return;
        }
        visited.add(this); // we shall not collect data here again
        dataList.add(this.data);
        for (Node<E> successor : this.successors) {
            successor.collectData(dataList, visited);
        }
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
