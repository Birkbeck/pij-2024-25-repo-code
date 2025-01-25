package pij.day14solution.listRec;

import pij.day14.list.SimpleList;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of SimpleList<E> using a generic singly-linked list.
 * Implemented using recursion.
 *
 * @param <E> the type of elements in this list
 */
public class SimpleLinkedListRec<E> implements SimpleList<E> {

    /**
     * The first element of the list. If it is null, this means that the list
     * is currently empty.
     */
    private NodeRec<E> head;

    /**
     * Constructs an empty list.
     */
    public SimpleLinkedListRec() {
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
    public SimpleLinkedListRec(SimpleList<? extends E> copyMe) {
        this.head = NodeRec.copyFrom(copyMe, 0);
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
    public SimpleLinkedListRec(SimpleLinkedListRec<? extends E> copyMe) {
        this.head = NodeRec.copy(copyMe.head);
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
            this.head = new NodeRec<>(element, this.head);
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
