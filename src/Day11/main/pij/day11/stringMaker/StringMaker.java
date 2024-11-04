package pij.day11.stringMaker;

public class StringMaker {
    public static String build(int max) {
        String s = "";
        for (int i = 0; i < max; i++) {
            s += i;
        }
        return s;
    }
}
