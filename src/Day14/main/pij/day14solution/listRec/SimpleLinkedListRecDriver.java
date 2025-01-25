package pij.day14solution.listRec;

import pij.day14.list.SimpleList;

/**
 * Driver class for interface SimpleList and class SimpleLinkedList.
 */
public class SimpleLinkedListRecDriver {


    private static SimpleLinkedListRec<Integer> makeTestData() {
        SimpleLinkedListRec<Integer> result = new SimpleLinkedListRec<>();
        result.add(0, 100);
        result.add(1, 101);
        result.add(2, 102);
        result.add(3, 103);
        return result;
    }

    public static void main(String[] args) {
        SimpleList<Integer> simpleList = new SimpleLinkedListRec<>();
        pij.day14solution.list.SimpleListDriver.driveInteger(simpleList);

        SimpleLinkedListRec<Integer> myList = makeTestData();
        SimpleLinkedListRec<Integer> copy = new SimpleLinkedListRec<>(myList);
        System.out.println(myList);
        System.out.println(copy);
    }
}
