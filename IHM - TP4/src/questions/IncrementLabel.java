package questions;

import javax.swing.*;
import java.awt.*;

public class IncrementLabel {
    private JFrame window;
    private JLabel label;
    private JButton button;

    public IncrementLabel() {
        window = new JFrame("Incrementer");
        label = new JLabel("0");
        button = new JButton("Incrementer");

        window.setSize(new Dimension(320,240));
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        window.getContentPane().add(label);
        window.getContentPane().add(button);
        window.setVisible(true);
    }

    public static void main(String[] args) {

        IncrementLabel inc = new IncrementLabel();
    }
}
