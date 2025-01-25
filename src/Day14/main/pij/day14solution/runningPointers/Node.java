package pij.day14solution.runningPointers;

/**
 * A node for a generic singly-linked list with a data element and
 * a pointer to the next node.
 *
 * Here the version for the solution of Exercise 6, so with only
 * methods that are somehow used in this exercise.
 *
 * @param <E> the type of elements in the node
 */
class Node<E> {
    /** The payload of this node. May be null. */
    private E data;

    /**
     * The next element of the list from this node. If it is null,
     * this means that there is no next element.
     */
    private Node<E> next;

    /**
     * Constructs a new Node<E> storing data and next.
     *
     * @param data data to be stored in this Node<E>
     * @param next pointer to the next node to be stored in this Node<E>
     */
    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Constructs a new Node<E> storing data. This node has no next node.
     *
     * @param data to be stored in this Node<E>
     */
    public Node(E data) {
        this(data, null);
    }

    /**
     * Solution for Exercise 6. Look at it only after you have given it a try!
     *
     * Note that for Node objects as used from class SimpleLinkedList, this
     * method should /always/ return true!
     *
     * @return true if the Node structure eventually reaches the null
     *  reference by following the reference to the next Node, false otherwise
     *  (i.e., it ends in a cycle structure of arbitrary length)
     */
    public boolean endsInNull() {
        // Idea:
        // If the structure does end in null, we will eventually reach
        // null by following the reference to the next field repeatedly
        // using a pointer in a loop.
        // But if the structure does /not/ end in null, following the
        // reference to the next field will never end! So we would never
        // know when we should return false.
        // But... if we follow the reference to the next field repeatedly and
        // end up in a cycle, we will visit at least one Node over and over.
        // We are not allowed, e.g., a Set data structure to track which
        // Nodes we have seen. But we can use /two/ pointers to Nodes
        // and give one of them a "head start". The pointer with the
        // head start will also take "two steps at a time", so run through
        // a possible cycle at the end in "double speed". The other
        // pointer will visit only one Node at a time. Eventually, both
        // pointers will be in the cycle (if there is one). Then the fast
        // pointer will also eventually catch up the slow pointer (they
        // both point to the same memory location). And then we know that
        // there is a cycle!
        Node<E> slowPointer = this;
        Node<E> fastPointer = this.next;
        while (fastPointer != null) {
            if (fastPointer == slowPointer) {
                // same memory location, we are on a cycle!
                return false;
            }

            // slowPointer goes 1 step forward
            slowPointer = slowPointer.next;
            // null check to avoid NullPointerException is not needed here
            // (bonus question: why not?)

            // fastPointer goes 2 steps forward
            // make step 1 ...
            fastPointer = fastPointer.next;
            if (fastPointer == null) {
                // step 2 may not be possible if we are already at null
                return true;
            }
            // ... now it is safe to make step 2
            fastPointer = fastPointer.next;
        }
        // reached null => the answer for the method must be true
        return true;
    }

    /* The following methods were not required for the exercise, but are very
     * helpful for testing the solution.
     */

    /**
     * Returns a new linked list with length Nodes ending in null.
     * @param length the number of Nodes on the list
     * @return a new linked list with length Nodes ending in null
     * @param <E> generic type for the data object
     * @throws IllegalArgumentException if length is less than 0
     */
    public static <E> Node<E> makeListEndingInNull(int length) {
        return makeListEndingIn(length, null);
    }

    /**
     * Returns a new linked list with length Nodes ending in end.
     * @param length the number of Nodes on the list
     * @param end the Node to which the last Node of this list should point
     *            (if length is 0, end itself is returned)
     * @return a new linked list with length Nodes ending in end
     * @param <E> generic type for the data object
     * @throws IllegalArgumentException if length is less than 0
     */
    private static <E> Node<E> makeListEndingIn(int length, Node<E> end) {
        if (length < 0) {
            throw new IllegalArgumentException("length at least 0 expected, found " + length);
        }
        final E DATA = null; // the data content does not matter for us
        Node<E> result = end;
        for (int i = 0; i < length; i++) {
            result = new Node<>(DATA, result);
        }
        return result;
    }

    /**
     * Returns a new "lasso-shaped" structure of Node references: at the end,
     * there is a cycle with cycleLength + 1 Nodes, and that cycle is pointed
     * to by a list of stemLength Nodes.
     *
     * @param stemLength the number of Nodes that are only on the stem of the
     *                   lasso
     * @param cycleLength the number of Nodes that are on the cycle and not
     *                    referenced from the stem
     * @return a "lasso-shaped" structure of Node references: at the end, there
     *  is a cycle with cycleLength + 1 Nodes, and that cycle is pointed to by a
     *  list of stemLength Nodes
     * @param <E> generic type for the data object
     * @throws IllegalArgumentException if stemLength or cycleLength are less
     *  than 0
     */
    public static <E> Node<E> makeListEndingInCycle(int stemLength, int cycleLength) {
        final E DATA = null; // the data content does not matter for us

        // start with a single Node: cycleStart --next--> null
        Node<E> cycleStart = new Node<>(DATA, null);

        // now extend the list (for the cycle) with cycleLength more Nodes:
        // cycleCurrent --next--> ... --next--> cycleStart --next--> null
        Node<E> cycleCurrent = makeListEndingIn(cycleLength, cycleStart);

        // now close the cycle:
        // cycleCurrent --next--> ... --next--> cycleStart
        //      ^                                    |
        //      |                                    |
        //      \                                    /
        //       ------------------next--------------
        cycleStart.next = cycleCurrent;

        // now add a list from a Node stemStart that ends in Node cycleStart
        // to get a "lasso-shaped" structure:
        //
        // stemStart  --next-->  ...  -----next-----
        //                                          \
        //                                           |
        //                                           |
        //                                           v
        // cycleCurrent --next--> ... --next--> cycleStart
        //      ^                                    |
        //      |                                    |
        //      \                                    /
        //       ------------------next--------------
        Node<E> stemStart = makeListEndingIn(stemLength, cycleStart);
        return stemStart;
    }
}
