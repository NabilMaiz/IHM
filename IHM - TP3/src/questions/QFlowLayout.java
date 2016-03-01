package questions;

import utils.MainWindow;

import javax.swing.*;
import java.awt.*;

public class QFlowLayout extends MainWindow {

    public QFlowLayout() {

        initWindow();
        this.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));


        for (int i = 1; i <= 16; i++) {
            this.add(new JButton("Bouton"+ i));
        }

        this.setVisible(true);


    }
}
