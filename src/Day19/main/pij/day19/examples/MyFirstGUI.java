package pij.day19.examples;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import java.awt.Font;

/**
 * This class provides a small example of a program using a Swing GUI.
 */
public class MyFirstGUI {

    // some constants to configure the GUI (avoid magic numbers)
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final int COLUMN_WIDTH = 20;

    /**
     * Constructs all the components for our GUI, puts them into
     * a suitably configured JFrame, and makes the JFrame visible.
     */
    public MyFirstGUI() {
        // set up all the components of the GUI
        JLabel instructionLabel = new JLabel("Please enter something to put to upper case.");
        JLabel outputLabel = new JLabel(); // empty at first
        JTextField inputTextField = new JTextField(COLUMN_WIDTH); // inputs can be longer!

        // ActionListener is a functional interface, so we can implement it
        // with a lambda expression
        inputTextField.addActionListener((ae) -> {
            // the functionality is very simple, so in this small example
            // it is directly present in the code for the ActionListener
            String s = inputTextField.getText();
            outputLabel.setText(s + " in upper case: " + s.toUpperCase());
            // note: lambda expressions are allowed to access
            // "effectively final" variables that are in their scope, even if
            // these variables are not their parameters nor declared inside
            // the lambda expression; here: inputTextField and outputLabel
        });

        JButton button = new JButton("Hello, Swing!");
        button.addActionListener((ae) -> {
            // different event handler for our button: it has functionality, too!
            outputLabel.setText("Greetings to Birkbeck from the GUI!");
        });

        // everything will be shown in a JFrame (it's like a window)
        JFrame jFrame = new JFrame("Hello, World!");
        jFrame.setLayout(new FlowLayout()); // reasonable "first default choice"
        jFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        // vary the constants for your needs

        // when the window closes, the program should terminate
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // now put the components into the JFrame in the desired order
        jFrame.add(instructionLabel);
        jFrame.add(inputTextField);
        jFrame.add(button);
        jFrame.add(outputLabel);

        // On modern displays with high pixel density, the default size of
        // the fonts for the components may be a bit small. Let's help them:

        // retrieve the current font...
        Font oldFont = UIManager.getFont("Label.font");
        // ...and make it twice as large (note the cast to float!)...
        Font newFont = oldFont.deriveFont((float) (oldFont.getSize()*2));
        // ...and tell the relevant components about it
        instructionLabel.setFont(newFont);
        outputLabel.setFont(newFont);
        inputTextField.setFont(newFont);
        button.setFont(newFont);

        // actually show the JFrame
        jFrame.setVisible(true);
    }

    /**
     * Runs the Swing GUI for our example.
     */
    public static void main(String[] args) {
        // use a method reference to the constructor (!) for the code to run
        // by the GUI thread; it can be used as a Runnable, too
        SwingUtilities.invokeLater(MyFirstGUI::new);
        // alternative:
        //SwingUtilities.invokeLater(() -> new MyFirstGUI());
    }
}
