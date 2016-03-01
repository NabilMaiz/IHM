package questions;

import utils.MainWindow;

import javax.swing.*;
import java.awt.*;

public class QGridLayout extends MainWindow {

    private GridLayout experimentLayout;
    public QGridLayout() {


        initWindow();
        this.experimentLayout = new GridLayout(4,4);

        this.getContentPane().setLayout(this.experimentLayout);


        for (int i = 1; i <= 16; i++) {
            this.add(new JButton("Bouton"+ i));
        }

        this.setVisible(true);


    }
}
