package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 3;
    private static final String TITLE = "My first Java graphical interface";
    private final JFrame frame = new JFrame(TITLE);
    private final JPanel canvas;
    private final JPanel canvas2;

    SimpleGUI() {

        final SimpleController controller = new SimpleController();
        this.canvas = new JPanel();
        this.canvas2 = new JPanel();
        final JTextField text = new JTextField();
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFocusable(false);
        canvas.setLayout(new BorderLayout());
        final JButton printButton = new JButton("Print");
        final JButton showHistoryButton = new JButton("Show history");
        canvas.add(text, BorderLayout.NORTH);
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(canvas2, BorderLayout.SOUTH);
        canvas2.add(printButton, BorderLayout.LINE_START);
        canvas2.add(showHistoryButton, BorderLayout.LINE_END);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        printButton.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setString(text.getText());
                System.out.println(controller.getString()); //NOPMD
            }
        });

        showHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                textArea.setText(controller.allStringHistory());
            }
        });

    }

    void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * main for tests.
     * 
     * @param args args for the main
     */
    public static void main(final String... args) {
        new SimpleGUI().display();
    }
}
