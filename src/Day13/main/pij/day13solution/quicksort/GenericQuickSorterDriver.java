package pij.day13solution.quicksort;

import java.util.List;

public class GenericQuickSorterDriver {
    public static void main(String[] args) {
        List<String> words = List.of("c", "a", "e", "b", "d");
        List<String> quickSorted = GenericQuickSorter.quicksort(words);
        System.out.println(quickSorted);
    }
}
