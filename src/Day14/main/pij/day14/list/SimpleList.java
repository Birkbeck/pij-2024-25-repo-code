package pij.day14.list;

import java.util.List;

/**
 * SimpleList provides a simplified variant of the interface java.util.List,
 * allowing for basic list operations.
 *
 * @param <E> the generic type of the elements of this SimpleList
 */
public interface SimpleList<E> {

    /**
     * Returns whether this SimpleList is empty, i.e., whether it has size 0.
     * (For many implementations, using this method is likely to be more
     * efficient than writing <code>list.size() == 0</code>.)
     *
     * @return whether this SimpleList is empty
     */
    boolean isEmpty();

    /**
     * Returns the size of this SimpleList, i.e., the number of entries.
     *
     * @return the size of this SimpleList
     */
    int size();

    /**
     * Retrieves and returns the element at the given index.
     *
     * @param index the index for which to retrieve the element
     * @return the element at the given index
     * @throws IllegalArgumentException if index < 0 or index >= size()
     */
    E get(int index);

    /**
     * Returns whether this SimpleList contains an element that is equal to the given
     * object, as indicated by method equals(). If o == null, return whether this
     * SimpleList contains a null element.
     *
     * @param o the element to check for containment
     * @return whether this SimpleList contains an element that is equal to the given
     *  object
     */
    boolean contains(Object o);

    /**
     * Returns the index of the first occurrence of o in this SimpleList, or
     * -1 if o does not occur in this SimpleList.
     *
     * @param o the element for which we want the first index
     * @return the first index of o in this SimpleList, or -1 if o does not
     *  occur in this SimpleList
     */
    int indexOf(Object o);

    /**
     * Clears this SimpleList. After calling this method, the list will be empty.
     */
    void clear();

    /**
     * Replaces the list entry at the given index by element.
     *
     * @param index the index where the list content is supposed to be replaced
     *              by element
     * @param element the element to store at the given index
     * @return the element previously at the given index
     * @throws IllegalArgumentException if index < 0 or index >= size()
     */
    E set(int index, E element);

    /**
     * Adds the given element at the given position. The position of all list
     * contents previously at position index or higher is shifted to the
     * right by one.
     *
     * @param index the position at which to add the given element
     * @param element the element to add to this SimpleList
     * @throws IllegalArgumentException if index < 0 or index > size()
     */
    void add(int index, E element);

    /**
     * Removes and returns the element at the given position from this
     * SimpleList.  The position of all list contents previously at a
     * position higher than index is shifted to the left by one.
     *
     * @param index the position at which we want to remove the given
     *              element.
     * @return the element that was just deleted from the given position
     *  in this SimpleList
     * @throws IllegalArgumentException if index < 0 or index >= size()
     */
    E remove(int index);

    /**
     * Returns a String representation of this SimpleList.
     *
     * @return a String representation of this SimpleList
     */
    String toString();

    /**
     * Returns a list (from the Java Collections Framework) with the same
     * content and order as this SimpleList. The returned list may be
     * modified without affecting the structure of this SimpleList.
     *
     * @return a list with the same content and order as this SimpleList
     */
    List<E> toList();
}
