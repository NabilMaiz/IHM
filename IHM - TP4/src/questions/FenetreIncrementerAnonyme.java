package questions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreIncrementerAnonyme {

        private JFrame window;
        private JLabel label;
        private JButton button;

        public FenetreIncrementerAnonyme() {

            window = new JFrame("Incrementer");
            label = new JLabel("0");
            button = new JButton("Incrementer");

            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    updateLabel(e);
                }
            });

            window.setSize(new Dimension(320,240));
            window.setLocationRelativeTo(null);

            /* Implementation de la fermeture de fenetre avec un adapter perso */
            window.addWindowListener(new FermetureFenetre());
            /* Implementation de la fermeture de fenetre avec un adapter perso */

            window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
            window.getContentPane().add(label);
            window.getContentPane().add(button);
            window.setVisible(true);
        }

        private void updateLabel(ActionEvent e) {

            int current = Integer.parseInt(label.getText());
            current++;
            label.setText(String.valueOf(current));
        }

    public static void main(String[] args) {

        FenetreIncrementerAnonyme inc = new FenetreIncrementerAnonyme();
    }

}
