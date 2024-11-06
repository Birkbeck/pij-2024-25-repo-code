package pij.day10;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Reads a text file and prints its content. Uses the functionality
 * of the java.nio package with interface Path and helper class Files.
 */
public class TextFileReader3 {
    public void readAndPrintFile(String path) {
        File file = new File(path);
        Path p = file.toPath();
        // The following approach can be handy if you want a fixed Path.
        //Path p = Path.of("src", "Day10", "pij", "day10", "TestText.txt");
        try {
            for (String line : Files.readAllLines(p)) {
                // ... do things with the data here
                System.out.println("READ LINE: " + line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
