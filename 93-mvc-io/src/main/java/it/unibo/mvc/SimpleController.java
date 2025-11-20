package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * SimpleController.
 *
 */
public final class SimpleController implements Controller {

    private static List<String> list = new LinkedList<>();
    private String lastString;

    /**
     * Constructor.
     */
    SimpleController() {
        this.lastString = null;
    }

    /**
     * @param t the variable that has to be check if its null
     * @param <T> generic
     * 
     * @return true if is null, false otherwise.
     */
    public <T> boolean isNull(final T t) {
        return t == null;
    }

    @Override
    public void setString(final String s) {
        if (isNull(s)) {
            throw new IllegalArgumentException("s can't be null");
        } else {
            this.lastString = s;
            list.addLast(s);
        }
    }

    @Override
    public String getString() {
        return this.lastString;
    }

    @Override
    public String allStringHistory() {
        return list.toString();
    }

    @Override
    public void printCurrentString() {
        if (isNull(this.lastString)) {
            throw new IllegalStateException("the current string is null, set a string ( setString() ) before printing it");
        }
        System.out.println(this.lastString); //NOPMD
    }

}
