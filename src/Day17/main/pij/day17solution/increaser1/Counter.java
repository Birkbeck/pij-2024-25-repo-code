package pij.day17solution.increaser1;

public class Counter {
    private int n;

    // First attempt at a solution: make method increase() synchronised.
    // Then any thread that wants to run method increase() must first
    // acquire the lock for the Counter object, and only one thread at
    // a time can run the (non-atomic!) increment operation in the
    // method body.
    // Downside: now method increase() of class Counter incurs the
    // overhead of synchronisation at runtime also in other contexts
    // where it is not needed, e.g., if just a single thread is
    // accessing a Counter object.
    public synchronized void increase() {
        this.n++;
    }

    public int getCount() {
        return this.n;
    }
}
