package pij.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * A TextFileWriter provides a method to write a String into a specified file.
 */
public class TextFileWriter {

    /**
     * Writes given text content to a file. Note that the old content of the
     * file will be erased!
     *
     * @param content to write to file
     * @param path the path where we will write content;
     *             the old content of the file will be erased!
     * @throws NullPointerException if path is null
     */
    public void writeContentToPath(String content, String path) {
        File file = new File(path);

        try (PrintWriter out = new PrintWriter(file)) {
            out.write(content);// alternative 1
            //out.print(content);// alternative 2
            //out.println(content);// alternative 3
            //out.printf(content);// alternative 4
        } catch (FileNotFoundException ex) {
            System.out.println("Cannot write to file " + file + ".");
        }
    }
}
