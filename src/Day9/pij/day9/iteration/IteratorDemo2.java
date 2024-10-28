package pij.day9.iteration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo2 {
    public static void main(String[] args) {
        List<String> container = new ArrayList<>(Arrays.asList("A", "B"));
        Iterator<String> iter = container.iterator();
        container.add("C");
        if (iter.hasNext()) {
            String s = iter.next(); // ConcurrentModificationException
        }
    }
}
