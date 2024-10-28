package pij.day9.iteration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IteratorDemo1 {
    public static void main(String[] args) {
        List<String> container = new ArrayList<>(Arrays.asList("A", "B"));
        for (String s : container) { // uses Iterator over container to get s
            container.add("C"); // modifies container
        }
    }
}
