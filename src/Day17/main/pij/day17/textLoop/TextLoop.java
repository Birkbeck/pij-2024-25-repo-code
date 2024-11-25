package pij.day17.textLoop;

public class TextLoop implements Runnable {
    public static final int ITERATIONS_PER_RUNNABLE = 10;
    public static final int NUMBER_OF_RUNNABLES = 10;
    public static final String MODE0 = "0";
    public static final String MODE1 = "1";

    private final String name;

    public TextLoop(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < ITERATIONS_PER_RUNNABLE; i++) {
            System.out.println("Loop: " + this.name + ", iteration: " + i + ".");
        }
    }

    public static void main(String[] args) {
        if (args.length < 1 || (!args[0].equals(MODE0) && !args[0].equals(MODE1))) {
            System.out.println("USAGE: java TextLoop <mode>");
            System.out.println("     mode " + MODE0 + ": without threads");
            System.out.println("     mode " + MODE1 + ": with threads");
        } else if (args[0].equals(MODE0)) {
            for (int i = 0; i < NUMBER_OF_RUNNABLES; i++) {
                Runnable r = new TextLoop("Thread " + i);
                r.run();
            }
        } else {
            for (int i = 0; i < NUMBER_OF_RUNNABLES; i++) {
                Runnable r = new TextLoop("Thread " + i);
                Thread t = new Thread(r);
                t.start();
            }
        }
    }
}
