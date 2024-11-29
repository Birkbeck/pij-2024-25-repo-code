package pij.day19.examples;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;

/**
 * This class provides a small example of a program using a Swing GUI.
 */
public class JCheckboxExampleGUI {

    // some constants to configure the GUI (avoid magic numbers)
    private static final int WIDTH = 640, HEIGHT = 360;

    /**
     * Constructs all the components for our GUI, puts them into
     * a suitably configured JFrame, and makes the JFrame visible.
     */
    public JCheckboxExampleGUI() {
        JFrame jFrame = new JFrame("Using a JCheckbox");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(WIDTH, HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel outputLabel = new JLabel("Nothing done with the checkbox yet!");
        JCheckBox box = new JCheckBox("My first checkbox");

        // we could also use an ActionListener
        box.addItemListener((ie) -> {
            // here: direct access to box (we know which one was used);
            // we could also use ie.getItem() if ie could be from several sources
            boolean isTicked = box.isSelected();
            outputLabel.setText("Box status: " + isTicked);
        });

        // now put the components into the JFrame in the desired order
        jFrame.add(box);
        jFrame.add(outputLabel);
        jFrame.setVisible(true);
    }

    /**
     * Runs the Swing GUI for our example.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(JCheckboxExampleGUI::new);
    }
}
