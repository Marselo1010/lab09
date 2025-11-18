package it.unibo.mvc;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 3;
    private static final String TITLE = "My first Java graphical interface";
    private final JFrame frame = new JFrame(TITLE);

    /**
     * constructor.
     */
    public SimpleGUIWithFileChooser() {
            final Controller controller = new Controller();
            final SimpleGUI gui = new SimpleGUI(controller);
            final JPanel topPanel = new JPanel();
            final JFileChooser chooseFile = new JFileChooser();
            final JTextField textField = new JTextField(controller.getCurrentFilePath());
            textField.setEditable(false);
            textField.setFocusable(false);
            final JButton browseButton = new JButton("Browse...");
            topPanel.setLayout(new BorderLayout());
            topPanel.add(textField, BorderLayout.CENTER);
            topPanel.add(browseButton, BorderLayout.LINE_END);
            gui.getCanvas().add(topPanel, BorderLayout.NORTH);
            frame.setContentPane(gui.getCanvas());

            browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                System.out.println("cliccato browse..."); //NOPMD
                final int filechooser = chooseFile.showSaveDialog(null);
                if (filechooser == JFileChooser.APPROVE_OPTION) {
                    controller.setCurrentFile(chooseFile.getSelectedFile());
                    System.out.println("new file selected --> " //NOPMD
                    + controller.getCurrentFilePath());
                    textField.setText(controller.getCurrentFilePath());
                    System.out.println(controller.getCurrentFile()); //NOPMD
                    System.out.println(controller.getCurrentFilePath()); //NOPMD
                } else if (filechooser == JFileChooser.CANCEL_OPTION) {
                    assert true;
                } else {
                    JOptionPane.showMessageDialog(frame, "An error has occurred while selecting the file", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
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
     * main for test.
     * 
     * @param args args for main
     */
    public static void main(final String... args) {
        new SimpleGUIWithFileChooser().display();
    }
}
