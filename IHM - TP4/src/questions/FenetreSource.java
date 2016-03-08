package questions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreSource {

    private JFrame window;
    private JLabel label;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public FenetreSource() {

        initWindow();
    }

    private void initWindow() {

        window = new JFrame("Incrementer");
        label = new JLabel("0");
        button1 = new JButton("Button1");
        button2 = new JButton("Button2");
        button3 = new JButton("Button3");

        window.setSize(new Dimension(320,240));
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        window.getContentPane().add(label);
        window.getContentPane().add(button1);
        window.getContentPane().add(button2);
        window.getContentPane().add(button3);
        window.setVisible(true);

        button1.addActionListener(new SourceEventHandler());
        button2.addActionListener(new SourceEventHandler());
        button3.addActionListener(new SourceEventHandler());
    }

    private class SourceEventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1)
                label.setText("Button 1");
            else if (e.getSource() == button2)
                label.setText("Button 2");
            else
                label.setText("Button 3");
        }
    }


    public static void main(String[] args) {
        FenetreSource fs = new FenetreSource();
    }
}
