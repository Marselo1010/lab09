package it.unibo.mvc;

/**
 *
 */
public interface Controller {

    /**
     * A method for setting the next string to print.
     * Null values are not acceptable, and an exception should be produced.
     * 
     * @param s string 
     */
    void setString(String s);

    /**
     * A method for getting the next string to print.
     * 
     * @return next string to print 
     */
    String getString();

    /**
     * A method for getting the history of the printed strings (in form of a `List` of `Strings`).
     * 
     * @return the history of printed strings
     */
    String allStringHistory();

    /**
     * A method that prints the current string. 
     * If the current string is unset, an `IllegalStateException` should be thrown.
     */
    void printCurrentString();

}
