package it.unibo.mvc;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JTextArea;

import javax.swing.BoxLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    /*
     * Once the `Controller` is done, implement `SimpleGUI` class in such a way that:

        1. It has a main method that starts the graphical application
        2. In its constructor, sets up the whole view
        3. The graphical interface consists of a `JTextArea` with a button "Save" right below 
           (see `src/test/resources/ex02.png` for the expected result). 
        4. SUGGESTION: Use a `JPanel` with `BorderLayout`
        5. By default, if the graphical interface is closed the program must exit 
           (call `setDefaultCloseOperation`)
        6. The program asks the controller to save the file if the button "Save" gets pressed.

        See `src/test/resources/ex02.png` to verify the expected aspect.
     */
    private final static String TITLE = "My first Java graphical interface";
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame(TITLE);
    private final JPanel canvas;

    SimpleGUI(){
        this.canvas = new JPanel();
        final JTextArea text = new JTextArea();
        canvas.setLayout(new BorderLayout());
        final JButton button = new JButton("Save");
        canvas.add(button,BorderLayout.SOUTH);
        canvas.add(text,BorderLayout.CENTER);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                System.out.println("da finire"); // NOPMD suppressed as it is a false positive
                Controller controller = new Controller();
                controller.setCurrentFile(null);
            }
        });


    }

    public JPanel getCanvas(){
        return this.canvas;
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
