package pij.day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads a text file and prints its content. Uses a finally block to ensure
 * that the file handle is returned to the operating system. This approach
 * is possible, but quite verbose. A better approach (in TextFileReader2) is
 * to use the try-with-resources statement.
 */
public class TextFileReader {
    public void readAndPrintFile(String path) {
        File file = new File(path);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                // ... do things with the data here
                System.out.println("READ LINE: " + line);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File " + file + " does not exist.");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
