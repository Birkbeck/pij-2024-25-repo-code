package pij.day13solution.mergesortRedux;

import java.util.List;

public class GenericMergeSorterDriver {
    public static void main(String[] args) {
        List<String> words = List.of("c", "a", "e", "b", "d");
        List<String> mergeSorted = GenericMergeSorter.mergesort(words);
        System.out.println(mergeSorted);
    }
}
