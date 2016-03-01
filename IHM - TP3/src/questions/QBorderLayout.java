package questions;

import utils.MainWindow;

import javax.swing.*;
import java.awt.*;

public class QBorderLayout extends MainWindow {

    public QBorderLayout() {

        initWindow();

        JButton SOUTH = new JButton("SOUTH");
        this.add(SOUTH, BorderLayout.SOUTH);

        JButton NORTH = new JButton("NORTH");
        this.add(NORTH, BorderLayout.NORTH);

        JButton EAST = new JButton("EAST");
        this.add(EAST, BorderLayout.EAST);

        JButton WEST = new JButton("WEST");
        this.add(WEST, BorderLayout.WEST);

        JButton CENTER = new JButton("CENTER");
        this.add(CENTER, BorderLayout.CENTER);

        this.setVisible(true);


    }
}
