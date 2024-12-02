package pij.day19.examples;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;

/**
 * A small "Hello World" style GUI with an empty window that has
 * "Hello, World!" as its title.
 */
public class HelloWorldGUI {
    /** The initial window width in pixels. */
    private static final int WIDTH = 640;

    /** The initial window height in pixels. */
    private static final int HEIGHT = 360;

    /**
     * The constructor of our GUI.
     */
    public HelloWorldGUI() {
        JFrame jFrame = new JFrame("Hello, World!"); // title
        jFrame.setSize(WIDTH, HEIGHT); // fix the size
        //jFrame.setLayout(new FlowLayout()); // reasonable "first default choice"
        // when the window closes, the program should terminate
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true); // show the window
    }

    /**
     * Runs the Swing GUI for our (very) small example.
     */
    public static void main(String[] args) {
        // use a method reference to the constructor (!) for the code to run
        // by the event-dispatching thread of the GUI; the method reference
        // can be used as a Runnable, too
        SwingUtilities.invokeLater(HelloWorldGUI::new);
        // alternatively:
        // SwingUtilities.invokeLater(() -> new MyFirstGUI());
    }
}
