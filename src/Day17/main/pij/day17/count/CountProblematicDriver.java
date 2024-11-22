package pij.day17.count;

/**
 * Example class to demonstrate that Java methods are not executed atomically,
 * but that control changes between different threads.
 */
public class CountProblematicDriver {

    private static void runOne(String prefix, CountProblematic cp) {
        int count = cp.getCount();
        if (count != 0) { // report only "unexpected" values
            System.out.println(prefix + " thread says: " + count);
        }
    }
    public static void main(String[] args) {
        final int LIMIT = 1000; // increase value if needed
        CountProblematic cp = new CountProblematic();
        Runnable myRunnable = () -> {
            for (int i = 0; i < LIMIT; i++) {
                runOne("New", cp);
            }
        };
        Thread t = new Thread(myRunnable);
        t.start();
        for (int i = 0; i < LIMIT; i++) {
            runOne("Old", cp);
        }
    }
}
