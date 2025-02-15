package pij.day17solution.increaser2;

public class Increaser implements Runnable {
    private Counter c;

    public Increaser(Counter counter) {
        this.c = counter;
    }

    @Override
    public void run() {
        final int NUMBER_OF_INCREASES = 1000;
        System.out.println("Starting at " + c.getCount());
        for (int i = 0; i < NUMBER_OF_INCREASES; i++) {
            // Solution 2:
            // Like in Solution 1, here a thread that wants to run the
            // increase() method of the shared Counter object this.c
            // must first acquire the lock. Here we use a synchronized
            // block for the call site of the method call that we want to
            // protect rather than labelling the increase() method itself
            // as synchronized.
            // This has the benefit that class Counter stays flexible:
            // now other programmers who may want to use a Counter in their
            // program can still choose whether they want to synchronise
            // calls to method increase(). If they know that they are using
            // their Counter object only in a single thread, there is no
            // point in having the extra overhead that comes with checking
            // the lock every time method increase() is called.
            synchronized (this.c) {
                this.c.increase();
            }
        }
        System.out.println("Stopping at " + c.getCount());
    }
    public static void main(String[] args) {
        final int NUMBER_OF_THREADS = 100;
        Counter counter = new Counter();
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            Increaser increaserTask = new Increaser(counter);
            Thread t = new Thread(increaserTask);
            t.start();
        }
    }
}
