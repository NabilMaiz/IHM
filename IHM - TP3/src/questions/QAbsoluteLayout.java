package questions;

import utils.MainWindow;

import javax.swing.*;
import java.awt.*;

public class QAbsoluteLayout extends MainWindow {

    public QAbsoluteLayout() {

        initWindow();
        this.setLayout(null);

        for (int i = 0; i < 9; i++) {
            JButton btn = new JButton("Button "+i);

            btn.setBounds(i*35,35*i,135,35);
            this.add(btn);
        }
        this.setVisible(true);


    }
}
