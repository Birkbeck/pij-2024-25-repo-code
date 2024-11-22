package pij.day17.immutable;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver class to show that getters that return mutable fields are
 * problematic: they break encapsulation by introducing "aliases"
 * that allow for accessing objects referenced from private fields
 * /directly/.
 * <p>
 * The problem comes up even without multiple threads (but it is also
 * an issue if we do have multiple threads).
 */
public class SafeUnsafeDriver {
    public static void sneaky(SafeClass s) {
        List<String> list = s.getEntries();
        list.clear(); // s is not affected!
        list.add(null);
    }

    public static void sneaky(UnsafeClass u) {
        List<String> list = u.getEntries(); // alias of u.entries!
        list.clear(); // now u.entries has length 0
        list.add(null); // now u has a null entry
    }

    public static List<String> makeExampleList() {
        List<String> result = new ArrayList<>();
        result.add("Programming");
        result.add("in");
        result.add("Java");
        return result;
    }

    public static void main(String[] args) {
        // With SafeClass, no harm is done: no mutable data from inside the
        // object is returned that could be "corrupted" by the sneaky method.
        List<String> safeInput = makeExampleList();
        SafeClass safe = new SafeClass(safeInput, 2.0);
        System.out.println("safe before sneaky: " + safe.getEntries());
        sneaky(safe);
        System.out.println("safe after sneaky: " + safe.getEntries());

        // With UnsafeClass, the sneaky method can affect our instance of
        // UnsafeClass through /aliasing/ of the field unsafe.entries.
        List<String> unsafeInput = makeExampleList();
        UnsafeClass unsafe = new UnsafeClass(unsafeInput, 2.0);
        System.out.println("unsafe before sneaky: " + unsafe.getEntries());
        sneaky(unsafe);
        System.out.println("unsafe after sneaky: " + unsafe.getEntries());
    }
}
