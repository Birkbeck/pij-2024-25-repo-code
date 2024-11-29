package pij.day19.examples;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * This class provides a small example of a program using a Swing GUI.
 */
public class JListScrollExampleGUI {

    // some constants to configure the GUI (avoid magic numbers)
    private static final int WIDTH = 640, HEIGHT = 360;

    /**
     * Constructs all the components for our GUI, puts them into
     * a suitably configured JFrame, and makes the JFrame visible.
     */
    public JListScrollExampleGUI() {
        JFrame jFrame = new JFrame("Using a JList with a JScrollPane");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(WIDTH, HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel outputLabel = new JLabel("Nothing selected yet!");
        String[] words = { "Alfa", "Bravo", "Charlie", "Echo", "Foxtrot",
                "Golf", "Hotel", "India", "Juliett", "Kilo", "Lima" };
        JList<String> list = new JList(words);
        //list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener((lse) -> {
            int[] selected = list.getSelectedIndices();
            outputLabel.setText("Selected: " +
                    Arrays.stream(selected)
                          .mapToObj(i -> words[i])
                          .collect(Collectors.joining(", ")));
        });
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setSize(60, 40);
        // now put the components into the JFrame in the desired order
        jFrame.add(scrollPane);
        jFrame.add(outputLabel);
        jFrame.setVisible(true);
    }

    /**
     * Runs the Swing GUI for our example.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(JListScrollExampleGUI::new);
    }
}
