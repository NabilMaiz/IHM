package questions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FenetreIncrementer {

    private JFrame window;
    private JLabel label;
    private JButton button;

    public FenetreIncrementer() {
        window = new JFrame("Incrementer");
        label = new JLabel("0");
        button = new JButton("Incrementer");

        button.addActionListener(new ReponseAuClick());

        window.setSize(new Dimension(320,240));
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        window.getContentPane().add(label);
        window.getContentPane().add(button);
        window.setVisible(true);
    }

    private class ReponseAuClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int current = Integer.parseInt(label.getText());
            current++;
            label.setText(String.valueOf(current));
        }
    }

    public static void main(String[] args) {

        FenetreIncrementer inc = new FenetreIncrementer();
    }

}

