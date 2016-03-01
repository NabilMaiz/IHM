package questions;

import utils.MainWindow;

import javax.swing.*;
import java.awt.*;

public class QBoxLayout extends MainWindow {

    public QBoxLayout() {

        initWindow();

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        for (int i = 0; i < 3; i++) {
            if(i == 2) this.add(Box.createGlue());
            this.add(new JButton("Button " + i));
        }

        this.setVisible(true);

    }
}
