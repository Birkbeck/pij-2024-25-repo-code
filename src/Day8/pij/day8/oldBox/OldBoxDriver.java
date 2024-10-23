package pij.day8.oldBox;

/**
 * A driver class (aka script, aka tester class) for the IntegerBox and
 * StringBox types, with non-compiling lines commented out.
 */
public class OldBoxDriver {
    public static void main(String[] args) {
        OldBox intBox = new OldBox(42);
        int x = (Integer) intBox.getData(); // ok
        OldBox strBox = new OldBox("Hello");
        String s = (String) strBox.getData(); // ok
        intBox = strBox; // (!)
        int y = (Integer) strBox.getData(); // (!)
    }
}
