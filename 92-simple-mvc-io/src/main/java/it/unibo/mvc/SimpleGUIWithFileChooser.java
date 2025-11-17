package it.unibo.mvc;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JTextArea;

import it.unibo.mvc.Controller;
import it.unibo.mvc.SimpleGUI;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final static String TITLE = "My first Java graphical interface";
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame(TITLE);

    public SimpleGUIWithFileChooser() {
            SimpleGUI neg = new SimpleGUI();
            JPanel canvas2 = new JPanel();
            canvas2.setLayout(new BorderLayout());
            final JButton button2 = new JButton("Browse...");
            canvas2.add(button2,BorderLayout.NORTH);
            frame.setContentPane(canvas2);
    }

    void display(){
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        //frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(final String... args) {
        new SimpleGUI().display();
    }

    

}
