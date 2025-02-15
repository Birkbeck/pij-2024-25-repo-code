package pij.day17solution.increaser1;

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
            this.c.increase();
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
