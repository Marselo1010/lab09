package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Controller is a simple helper class that manages a reference to a single
 * File and provides convenience operations to inspect and write to that file.
 */
public class Controller {

    private static final String DEFAULT_FILE_NAME = "output.txt";
    private File file;

    /**
     * constructor of Controller set default file name output.txt.
     *
     * @DEFAULT_FILE_NAME
     * 
     */

    public Controller() {
        this.file = new File(
            System.getProperty("user.home")
            + File.separator
            + DEFAULT_FILE_NAME
        );
    }

    /**
     * Sets the file currently associated with this controller.
     * 
     * @param newFile file that will be set
     * 
     */
    void setCurrentFile(final File newFile) {
        this.file = newFile;
    }

    /**
     * Returns the currently stored file used by this controller.
     * 
     * @return file
     * 
     */
    File getCurrentFile() {
        return this.file;
    }

    /**
     * Returns the absolute path of the file currently associated with this controller.
     * 
     * @return the absolute path
     * 
     */
    String getCurrentFilePath() {
        return this.file.getAbsolutePath();

    }

    /**
     * Writes the given string to the file associated with this controller using UTF-8 encoding.
     * 
     * @param s string that will be saved in the file
     * 
     */
    void write(final String s) {
        try (PrintStream ps = new PrintStream(file.getAbsolutePath(), StandardCharsets.UTF_8)) {
            ps.print(s);
        } catch (final IOException e) {
            System.err.println(e); //NOPMD
        }
    }
}
