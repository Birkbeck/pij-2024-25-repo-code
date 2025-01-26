package pij.day13solution.binarySearch;

import java.util.List;

public class BinarySearchDriver {
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 3, 5, 7, 9, 14, 16, 18, 20);
        int valueIn = 17;
        System.out.println(BinarySearch.find(list, valueIn));

        int valueNotIn = 7;
        System.out.println(BinarySearch.find(list, valueNotIn));

    }
}
