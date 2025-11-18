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

    private final static String TITLE = "My first Java graphical interface";
    private static final int PROPORTION = 3;
    private final JFrame frame = new JFrame(TITLE);

    public SimpleGUIWithFileChooser() {
            Controller controller = new Controller();
            SimpleGUI gui = new SimpleGUI(controller);
            JPanel topPanel = new JPanel();
            JFileChooser chooseFile = new JFileChooser();
            JTextField textField = new JTextField(controller.getCurrentFilePath());
            textField.setEditable(false);
            textField.setFocusable(false);
            final JButton browseButton = new JButton("Browse...");
            topPanel.setLayout(new BorderLayout());
            topPanel.add(textField,BorderLayout.CENTER);
            topPanel.add(browseButton,BorderLayout.LINE_END);
            gui.getCanvas().add(topPanel, BorderLayout.NORTH);
            frame.setContentPane(gui.getCanvas());

            browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("cliccato browse..."); // NOPMD suppressed as it is a false positive
                int filechooser = chooseFile.showOpenDialog(null);
                String err = "error";
                if (filechooser == JFileChooser.APPROVE_OPTION) {
                    controller.setCurrentFile(chooseFile.getSelectedFile());
                    System.out.println("new file selected --> " + controller.getCurrentFilePath()); // NOPMD suppressed as it is a false positive
                    textField.setText(controller.getCurrentFilePath());
                    System.out.println(controller.getCurrentFile());
                    System.out.println(controller.getCurrentFilePath());
                } else if (filechooser == JFileChooser.CANCEL_OPTION) {

                } else {
                    JOptionPane.showMessageDialog(browseButton, err);
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

    public static void main(final String... args) {
        new SimpleGUIWithFileChooser().display();
    }
}
