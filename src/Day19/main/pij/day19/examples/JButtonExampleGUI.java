package pij.day19.examples;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;

/**
 * This class provides a small example of a program using a Swing GUI.
 */
public class JButtonExampleGUI {

    // some constants to configure the GUI (avoid magic numbers)
    private static final int WIDTH = 640, HEIGHT = 360;

    /**
     * Constructs all the components for our GUI, puts them into
     * a suitably configured JFrame, and makes the JFrame visible.
     */
    public JButtonExampleGUI() {
        JFrame jFrame = new JFrame("Using a JButton");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(WIDTH, HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel outputLabel = new JLabel("No button press yet!");
        JButton button = new JButton("Make it so.");
        button.addActionListener((ae) -> {
            String command = ae.getActionCommand();
            outputLabel.setText("The JButton's command was: " + command);
        });

        // now put the components into the JFrame in the desired order
        jFrame.add(outputLabel);
        jFrame.add(button);
        jFrame.setVisible(true);
    }

    /**
     * Runs the Swing GUI for our example.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(JButtonExampleGUI::new);
    }
}
