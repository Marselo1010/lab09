package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final static String TITLE = "My first Java graphical interface";
    private static final int PROPORTION = 3;
    private final JFrame frame = new JFrame(TITLE);
    private final JPanel canvas;
    private final Controller controller; 

    SimpleGUI(Controller controller) {

        this.controller = controller;
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
                System.out.println("message saved in the file --> " + SimpleGUI.this.controller.getCurrentFile()); // NOPMD suppressed as it is a false positive
                SimpleGUI.this.controller.write(text.getText());
            }
        });

    }

    public JPanel getCanvas() {
        return this.canvas;
    }

    void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(final String... args) {
        Controller controller = new Controller();
        new SimpleGUI(controller).display();
    }
}
