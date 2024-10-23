package pij.day8.box;

/**
 * A driver class (aka script, aka tester class) for the Box&lt;T&gt; type,
 * with non-compiling lines commented out.
 */
public class BoxDriver {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<Integer>(42);
        int x = intBox.getData(); // No cast needed!
        Box<String> strBox = new Box<String>("Hello");
        String s = strBox.getData(); // No cast needed!
        //intBox = strBox; // Rejected by the compiler.
        //int y = (Integer) strBox.getData(); // Rejected by the compiler.
    }
}
