package pij.day14solution.doublyLinkedList;

import java.util.List;
import java.util.Objects;

/**
 * A node for a generic singly-linked list with a data element and
 * a pointer to the next node.
 *
 * @param <E> the type of elements in the node
 */
class DLLNode<E> {
    /** The payload of this node. May be null. */
    private E data;

    /**
     * The next element of the list from this node. If it is null,
     * this means that there is no next element.
     */
    private DLLNode<E> next;

    /**
     * The previous element of the list from this node. If it is null,
     * this means that there is no previous element.
     */
    private DLLNode<E> prev;

    /**
     * Constructs a new DLLNode<E> storing data and next.
     *
     * @param data data to be stored in this DLLNode<E>
     * @param next pointer to the next node to be stored in this Node<E>
     * @param prev pointer to the previous node to be stored in this Node<E>
     */
    public DLLNode(E data, DLLNode<E> next, DLLNode<E> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    /**
     * Constructs a new Node<E> storing data. This node has no next node.
     *
     * @param data to be stored in this Node<E>
     */
    public DLLNode(E data) {
        this(data, null, null);
    }

    /**
     * Returns the number of nodes that can be reached from this node.
     * Corresponds to the length of the list with this node as its first node.
     *
     * @return the number of nodes that can be reached from this node
     */
    public int size() {
        int result = 1; // at least 1 node in the list: this
        DLLNode<E> current = this.next;
        while (current != null) {
            current = current.next;
            result++;
        }
        return result;
    }

    /**
     * Returns the data object that is in the node at a distance of
     * <code>index</code> from this node.
     *
     * @param index the position of the data object relative to this node
     * @return the data object that is in the node at a distance of
     *  <code>index</code> from this node
     * @throws IllegalArgumentException if index < 0 or index >= size()
     */
    public E get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Illegal index < 0: " + index);
        }
        DLLNode<E> current = this.getNodeAt(index);
        return current.data;
    }

    /**
     * Returns the node that is max(n, 0) steps via the <code>next</code>
     * field away from this node.
     *
     * @param n number of steps to take
     * @return the node that is max(n, 0) steps via the <code>next</code>
     *  field away from this node
     * @throws IllegalArgumentException if n >= size() - 1
     */
    private DLLNode<E> getNodeAt(int n) {
        DLLNode<E> current = this;
        for (int i = 0; i < n; i++) {
            if (current.next == null) {
                throw new IllegalArgumentException("List has no element at position " + n);
            }
            current = current.next;
        }
        return current;
    }

    /**
     * Returns whether the list with this node as its first element contains
     * an element that is equal to the given object, as indicated by method
     * equals(). If o == null, return whether the list with this node as its
     * first element contains a null element.
     *
     * @param o the element to check for containment
     * @return whether a node reachable from this node contains an element that
     *  is equal to the given object
     */
    public boolean contains(Object o) {
        DLLNode<E> current = this;
        do {
            if (Objects.equals(o, current.data)) { // deals gracefully with null
                return true;
            }
            current = current.next;
        } while (current != null);
        return false;
    }

    /**
     * Returns the index of the first occurrence of o in the list with this
     * node as its first element, or -1 if o does not occur in the list.
     *
     * @param o the element for which we want the first index
     * @return the first index of o in the list with this node as its
     *  first element, or -1 if o does not occur in the list
     */
    public int indexOf(Object o) {
        int counter = 0; // first element at 0
        DLLNode<E> current = this;
        do {
            if (Objects.equals(o, current.data)) { // deals gracefully with null
                return counter;
            }
            current = current.next;
            counter++;
        } while (current != null);
        return -1;
    }

    /**
     * Replaces the list entry at the given index by element.
     *
     * @param index the index where the list content is supposed to be replaced
     *              by element
     * @param element the element to store at the given index
     * @return the element previously at the given index
     * @throws IllegalArgumentException if index < 0 or index >= size()
     */
    public E set(int index, E element) {
        if (index < 0) {
            throw new IllegalArgumentException("Illegal index < 0: " + index);
        }
        DLLNode<E> writeLocation = this.getNodeAt(index);
        E oldElement = writeLocation.data;
        writeLocation.data = element;
        return oldElement;
    }

    /**
     * Adds the given element at the given position. The position of all list
     * contents previously at position index or higher is shifted to the
     * right by one.
     *
     * @param index the position at which to add the given element
     * @param element the element to add to this SimpleList
     * @return the DLLNode in which the new data element got stored
     * @throws IllegalArgumentException if index < 0 or index > size()
     */
    public DLLNode<E> add(int index, E element) {
        if (index < 0) {
            throw new IllegalArgumentException("expected positive index, found: " + index);
        }
        if (index == 0) {
            DLLNode<E> freshNode = new DLLNode<>(element, this, null);
            this.prev = freshNode; // now this Node is no longer at index 0
            return freshNode;
        }
        DLLNode<E> current = this.getNodeAt(index - 1);

        // now we are right before the new position of element
        DLLNode<E> freshNode = new DLLNode<>(element, current.next, current);
        current.next = freshNode;
        if (freshNode.next != null) {
            // if we are not inserting at the end, the next neighbour will
            // need to know freshNode, too
            freshNode.next.prev = freshNode;
        }
        return freshNode;
    }

    /**
     * Removes and returns the element at the given position from this
     * Node.  The position of all list contents previously at a
     * position higher than index is shifted to the left by one.
     *
     * @param index the position at which we want to remove the given
     *              element.
     * @return the element that was just deleted from the given position
     *  in this Node
     * @throws IllegalArgumentException if index < 0 or index >= size()
     */
    public E remove(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("expected positive index, found: " + index);
        }
        if (index == 0) {
            E result = this.data;
            if (this.next != null) {
                this.next.prev = null;
            }
            return result;
        }
        DLLNode<E> current = this.getNodeAt(index - 1);
        if (current.next == null) {
            throw new IllegalArgumentException("cannot remove at " + index + ", list too short");
        }
        // now we are right before the node to remove, current.next
        E result = current.next.data;
        current.next = current.next.next; // unlink the list node to remove it
        if (current.next != null) {
            // restore doubly-linked pointer structure
            current.next.prev = current;
        }
        return result;
    }

    /**
     * Fills the parameter list with the content of this list,
     * in the same order.
     *
     * @param fillMe the list to which the content of this list should be added
     * @throws NullPointerException if fillMe is the null reference
     */
    public void fillList(List<E> fillMe) {
        DLLNode<E> current = this;
        do {
            fillMe.add(current.data);
            current = current.next;
        } while (current != null);
    }

    /**
     * Appends a String representation of the elements from this node to the
     * end of the list to the given StringBuilder.
     *
     * @param sb the StringBuilder to fill
     * @throws NullPointerException if sb is null
     */
    public void fillStringBuilder(StringBuilder sb) {
        DLLNode<E> current = this;
        do {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        } while (current != null);
    }

    /**
     * Returns the data stored in this node.
     *
     * @return the data stored in this node
     */
    public E getData() {
        return this.data;
    }

    /**
     * Returns the next node in the list.
     *
     * @return the next node in the list
     */
    public DLLNode<E> getNext() {
        return this.next;
    }
}
