package utils;

import dialogs.PDialog;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{

    protected JLabel text;
    protected PDialog dialog;

    public MainWindow() {
        initWindow();

    }

    protected void initWindow() {

        this.text = new JLabel("NAAABILEUHHHH !");

        this.setTitle("JFrame");
        this.setSize(new Dimension(320, 240));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocationRelativeTo(null);

    }
}
