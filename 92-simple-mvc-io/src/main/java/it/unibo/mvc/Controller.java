package it.unibo.mvc;

import java.io.File;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;



/**
 * Application controller. Performs the I/O.
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

    void setCurrentFile(File newFile){
        this.file = newFile;
    }

    File getCurrentFile(){
        return this.file;
    }

    String getCurrentFilePath(){
        return this.file.getAbsolutePath();

    }

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
