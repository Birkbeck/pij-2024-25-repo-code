package pij.day14solution.doublyLinkedList;

import pij.day14.list.SimpleList;

/**
 * Driver class for interface SimpleList and class SimpleLinkedList.
 */
public class DoublyLinkedListDriver {


    private static DoublyLinkedList<Integer> makeTestData() {
        DoublyLinkedList<Integer> result = new DoublyLinkedList<>();
        result.add(0, 100);
        result.add(1, 101);
        result.add(2, 102);
        result.add(3, 103);
        return result;
    }

    public static void main(String[] args) {
        SimpleList<Integer> simpleList = new DoublyLinkedList<>();
        pij.day14solution.list.SimpleListDriver.driveInteger(simpleList);

        DoublyLinkedList<Integer> myList = makeTestData();
        DoublyLinkedList<Integer> copy = new DoublyLinkedList<>(myList);
        System.out.println(myList);
        System.out.println(copy);
    }
}
