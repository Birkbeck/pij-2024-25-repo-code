package pij.day14solution.list;

import pij.day14.list.SimpleList;

/**
 * Driver class for interface SimpleList and class SimpleLinkedList.
 */
public class SimpleListDriver {

    public static void driveInteger(SimpleList<Integer> simpleList) {
        final int INSIDE = 8022;
        final int OUTSIDE = 42;

        printListInfo(simpleList);
        simpleList.add(0, 8021);
        simpleList.add(1, INSIDE);
        simpleList.add(0, 8020);
        simpleList.add(3, 8023);
        System.out.println(simpleList.get(2));
        printListInfo(simpleList);
        printElementInfo(simpleList, INSIDE);
        printElementInfo(simpleList, OUTSIDE);
        System.out.println(simpleList.set(3, OUTSIDE));
        printListInfo(simpleList);
        printElementInfo(simpleList, OUTSIDE);
        System.out.println(simpleList.remove(1));
        printListInfo(simpleList);

        System.out.println(simpleList.remove(0));
        printListInfo(simpleList);
        System.out.println(simpleList.remove(1));
        printListInfo(simpleList);

        simpleList.clear();
        printListInfo(simpleList);
        simpleList.add(0, 9030);
        printListInfo(simpleList);
    }

    private static <E> void printElementInfo(SimpleList<E> simpleList, E value) {
        System.out.println(simpleList + ".contains(" + value + "): " + simpleList.contains(value));
        System.out.println(simpleList + ".indexOf(" + value + "): " + simpleList.indexOf(value));
    }


    private static <E> void printListInfo(SimpleList<E> simpleList) {
        System.out.println(simpleList + ".isEmpty(): " + simpleList.isEmpty());
        System.out.println(simpleList + ".size(): " + simpleList.size());
    }

    private static SimpleLinkedList<Integer> makeTestData() {
        SimpleLinkedList<Integer> result = new SimpleLinkedList<>();
        result.add(0, 100);
        result.add(1, 101);
        result.add(2, 102);
        result.add(3, 103);
        return result;
    }

    public static void main(String[] args) {

        SimpleList<Integer> simpleList = new SimpleLinkedList<>();
        driveInteger(simpleList);

        SimpleLinkedList<Integer> myList = makeTestData();
        SimpleLinkedList<Integer> copy = new SimpleLinkedList<>(myList);
        System.out.println(myList);
        System.out.println(copy);
    }
}
