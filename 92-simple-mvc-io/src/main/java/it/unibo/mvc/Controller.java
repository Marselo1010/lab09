package it.unibo.mvc;

import java.io.File;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;




/**
 * Controller is a simple helper class that manages a reference to a single
 * File and provides convenience operations to inspect and write to that file.
 *
 * <p>Behavior overview:
 * <ul>
 *   <li>On construction, a default File is created in the user's home directory
 *       with the name {@code "output.txt"} (see {@link #DEFAULT_FILE_NAME}).</li>
 *   <li>{@link #setCurrentFile(File)} replaces the current File reference; passing
 *       {@code null} clears it.</li>
 *   <li>{@link #getCurrentFile()} returns the currently stored File reference (may
 *       be {@code null} if none has been set).</li>
 *   <li>{@link #getCurrentFilePath()} returns the absolute path of the current File.
 *       If the internal file reference is {@code null}, this method will throw a
 *       {@link NullPointerException} (consistent with calling {@code getAbsolutePath()}
 *       on a null reference).</li>
 *   <li>{@link #write(String)} writes the provided string to the current File using
 *       UTF-8 encoding and overwrites any existing contents. If the provided string
 *       is {@code null}, the literal {@code "null"} will be written (matching
 *       {@code PrintStream.print} semantics). The method uses a try-with-resources
 *       PrintStream so the stream is closed automatically.</li>
 * </ul>
 *
 * <p>Important implementation notes and limitations:
 * <ul>
 *   <li>{@code write} does not attempt to create missing parent directories. If the
 *       file cannot be created or opened (for example because a parent directory
 *       is missing or due to permission issues), the resulting exception is caught
 *       and its information is printed to {@code System.err}; the method does not
 *       propagate checked exceptions.</li>
 *   <li>Errors encountered while writing (I/O or runtime exceptions) are reported
 *       to {@code System.err} and suppressed from the caller (no exception is thrown).</li>
 *   <li>The class is not synchronized and therefore is not safe for concurrent
 *       access from multiple threads without external synchronization.</li>
 * </ul>
 *
 * <p>Usage notes:
 * <ul>
 *   <li>Callers that require robust error handling should check the existence and
 *       writability of the target file or its parent directories before calling
 *       {@code write}, or inspect {@code System.err} output when failures occur.</li>
 *   <li>To change the file used for I/O, call {@code setCurrentFile(File)} with a
 *       non-null {@code File} instance.</li>
 * </ul>
 *
 * @see java.io.File
 * @see java.io.PrintStream
 */
public class Controller {

    private File file;
    private static final String DEFAULT_FILE_NAME = "output.txt";

        /**
         * constructor of Controller set default file name output.txt 
         * @DEFAULT_FILE_NAME
         */

    public Controller(){
        this.file = new File(
            System.getProperty("user.home")
            + File.separator
            + DEFAULT_FILE_NAME
        );
    }

    /**
     * Sets the file currently associated with this controller.
     *
     * The controller will use the provided File instance as its "current file"
     * for subsequent input/output operations. Passing {@code null} clears the
     * current file reference.
     *
     * @param newFile the File to set as current, or {@code null} to clear it
     */
    void setCurrentFile(File newFile){
        this.file = newFile;
    }

    /**
     * Returns the currently stored file used by this controller.
     *
     * @return the current {@code File} instance, or {@code null} if no file has been set
     */
    File getCurrentFile(){
        return this.file;
    }

    /**
     * Returns the absolute path of the file currently associated with this controller.
     *
     * @return the absolute file system path of the current file as a String
     * @throws NullPointerException if the internal file reference is null
     */
    String getCurrentFilePath(){
        return this.file.getAbsolutePath();

    }

    /**
     * Writes the given string to the file associated with this controller using UTF-8 encoding.
     *
     * This method overwrites the file's current contents with the provided string. The underlying
     * stream is closed automatically. Any I/O or other runtime exceptions encountered while
     * opening or writing the file are caught and their information is printed to System.err;
     * the method does not propagate checked exceptions.
     *
     * If the provided string is {@code null}, the literal {@code "null"} will be written
     * (behavior consistent with PrintStream.print).
     *
     * Note: this method does not create missing parent directories; if the file cannot be created
     * or opened, the exception will be reported to System.err and no data will be written.
     *
     * @param s the string to write to the file
     */
    void write(String s) {
        try (PrintStream ps = new PrintStream(file.getAbsolutePath(),StandardCharsets.UTF_8)){
            ps.print(s);
        } catch (final Exception e) {
            System.err.println(e); //NOPMD
        }
    }

    public static void main(final String... args) {
       Controller neg = new Controller();
       System.out.println(neg.getCurrentFile());
       System.out.println(neg.getCurrentFilePath());
       neg.write("ciao son gm ");
    }
}
