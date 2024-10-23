package pij.day8.hardcodedBox;

/**
 * A driver class (aka script, aka tester class) for the IntegerBox and
 * StringBox types, with non-compiling lines commented out.
 */
public class HardcodedBoxDriver {
    public static void main(String[] args) {
        IntegerBox intBox = new IntegerBox(42);
        int x = intBox.getData(); // No cast needed!
        StringBox strBox = new StringBox("Hello");
        String s = strBox.getData(); // No cast needed!
        //intBox = strBox; // Rejected by the compiler.
        //int y = (Integer) strBox.getData(); // Rejected by the compiler.
    }
}
