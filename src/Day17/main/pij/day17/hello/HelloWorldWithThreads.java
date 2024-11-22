package pij.day17.hello;

/**
 * Driver class for Java's threads with very simple functionality.
 */
public class HelloWorldWithThreads {
    public static void main(String[] args) {
        // Run this code several times -- there are two different outcomes!
        Runnable myRunnable = () -> System.out.println("Hello, World! From the new thread.");
        Thread newThread = new Thread(myRunnable);
        newThread.start();
        System.out.println("The original thread says hi!");
    }
}
