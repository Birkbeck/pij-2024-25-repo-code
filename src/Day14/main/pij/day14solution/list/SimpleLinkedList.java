package pij.day14solution.list;

import pij.day14.list.SimpleList;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of SimpleList<E> using a generic singly-linked list.
 *
 * @param <E> the type of elements in this list
 */
public class SimpleLinkedList<E> implements SimpleList<E> {

    /**
     * The first element of the list. If it is null, this means that the list
     * is currently empty.
     */
    private Node<E> head;

    /**
     * Constructs an empty list.
     */
    public SimpleLinkedList() {
        // The default constructor is sufficient for our purposes:
        // head will be null. Thus, writing an empty constructor
        // is intentional here.
    }

    /**
     * Copy constructor to create a SimpleLinkedList with the same elements
     * in the same order as copyMe. Does not modify the parameter list.
     *
     * @param copyMe the list whose elements we want to copy to the list
     *               that we are creating
     * @throws NullPointerException if copyMe is the null reference
     */
    public SimpleLinkedList(SimpleList<? extends E> copyMe) {
        int size = copyMe.size(); // may take O(list.size()) time
        for (int i = 0; i < size; i++) {
            E data = copyMe.get(i); // may take O(i) time
            this.add(i, data); // takes O(i) time
        }
    }

    /**
     * Copy constructor to create a SimpleLinkedList with the same elements
     * in the same order as copyMe. Does not modify the parameter list.
     * Specialised constructor for SimpleLinkedList objects as parameters.
     *
     * @param copyMe the list whose elements we want to copy to the list
     *               that we are creating
     * @throws NullPointerException if copyMe is the null reference
     */
    public SimpleLinkedList(SimpleLinkedList<? extends E> copyMe) {
        // The next line alone would do the job, but it would not benefit
        // from our knowledge of the way class SimpleLinkedList is written
        // (benefit wrt runtime rather than length of code).
        //this((SimpleList<? extends E>)copyMe);

        // More efficient solution that uses our structure knowledge of class
        // SimpleLinkedList (specifically, that it is implemented as a chain
        // of Node objects).
        if (copyMe.isEmpty()) { // nothing to do, list is empty; O(1) time
            return;
        }

        // there is at least 1 element to copy
        Node<? extends E> currentCopyMe = copyMe.head; // the next node to copy
        E data = currentCopyMe.getData();
        this.head = new Node<>(data); // first element set
        Node<E> currentThis = this.head; // the current end node in the new list

        while (currentCopyMe.getNext() != null) { // anything left to copy?
            // move to the next node that we need to copy
            currentCopyMe = currentCopyMe.getNext();

            // get a reference to the data in the current node
            data = currentCopyMe.getData(); // O(1) time

            // add the data to the node structure under construction,
            // right after the current end node (position 1 from the
            // current end node)
            currentThis.add(1, data); // O(1) time

            // make the newly created node the new end node in the list
            // that we are constructing
            currentThis = currentThis.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public int size() {
        if (this.isEmpty()) {
            return 0;
        }
        return this.head.size();
    }

    @Override
    public E get(int index) {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Cannot get anything in an empty list!");
        }
        return this.head.get(index);
    }

    @Override
    public boolean contains(Object o) {
        if (this.isEmpty()) {
            return false;
        }
        return this.head.contains(o);
    }

    @Override
    public int indexOf(Object o) {
        if (this.isEmpty()) {
            return -1;
        }
        return this.head.indexOf(o);
    }

    @Override
    public void clear() {
        // Java's garbage collector will do the actual clearing of the memory
        this.head = null;
    }

    @Override
    public E set(int index, E element) {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Cannot set in an empty list!");
        }
        return this.head.set(index, element);
    }

    @Override
    public void add(int index, E element) {
        if (index == 0) {
            this.head = new Node<>(element, this.head);
        } else if (this.isEmpty()) {
            throw new IllegalArgumentException("Can add to empty list only at index 0, found " + index);
        } else {
            this.head.add(index, element);
        }
    }

    @Override
    public E remove(int index) {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Cannot remove from an empty list!");
        }
        if (index == 0) {
            E result = this.head.getData();
            this.head = this.head.getNext();
            return result;
        }
        return this.head.remove(index);
    }

    @Override
    public List<E> toList() {
        List<E> result = new ArrayList<>();
        if (! this.isEmpty()) {
            this.head.fillList(result);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (! this.isEmpty()) {
            this.head.fillStringBuilder(sb);
        }
        sb.append("]");
        return sb.toString();
    }
}
