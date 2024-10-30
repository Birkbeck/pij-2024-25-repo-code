package pij.day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads a text file and prints its content. Uses the try-with-resources
 * statement (recommended) to ensure that the file handle is returned to
 * the operating system.
 */
public class TextFileReader2 {
    public void readAndPrintFile(String path) {
        File file = new File(path);

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = in.readLine()) != null) {
                // ... do things with the data here
                System.out.println("READ LINE: " + line);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File " + file + " does not exist.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
