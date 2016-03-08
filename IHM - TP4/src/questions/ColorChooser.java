package questions;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ColorChooser {

    private JFrame window;
    private JTextField redField;
    private JTextField greeField;
    private JTextField blueField;
    private JTextField hexField;

    private JSlider red;
    private JSlider green;
    private JSlider blue;

    private JPanel preview;

    public ColorChooser() {
        initComponents();
        initWindow();



    }

    private void initWindow() {
        this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.window.setSize(320, 180);
        this.window.setResizable(false);
        this.window.setLocationRelativeTo(null);
        this.window.setVisible(true);

        addComponents();
        eventsHandlers();

    }

    private void initComponents() {

        this.window = new JFrame("Color chooser");
        this.redField = new JTextField("0");
        this.greeField = new JTextField("0");
        this.blueField = new JTextField("0");
        this.hexField = new JTextField("#000000");

        this.red = new JSlider(0,255, SwingConstants.HORIZONTAL);
        this.green = new JSlider(0,255, SwingConstants.HORIZONTAL);
        this.blue = new JSlider(0,255, SwingConstants.HORIZONTAL);

        this.preview = new JPanel();
        this.preview.setBackground(new Color(0,0,0));
    }


    private void addComponents() {

        /** Sliders **/
        JPanel sliders = new JPanel();
        sliders.setLayout(new BoxLayout(sliders, BoxLayout.Y_AXIS));
        sliders.add(this.red);
        sliders.add(this.green);
        sliders.add(this.blue);
        this.window.add(sliders, BorderLayout.WEST);

        /** TextFields **/
        JPanel textfields = new JPanel();
        textfields.setLayout(new BoxLayout(textfields, BoxLayout.Y_AXIS));
        textfields.add(redField);
        textfields.add(greeField);
        textfields.add(blueField);
        this.window.add(textfields, BorderLayout.CENTER);

        /** Previews **/
        JPanel previews = new JPanel();
        previews.setLayout(new BoxLayout(previews, BoxLayout.Y_AXIS));
        previews.add(hexField);
        previews.add(preview);
        this.window.add(previews, BorderLayout.EAST);
    }

    public void eventsHandlers() {
        red.addChangeListener(new SlidersHandler());
        green.addChangeListener(new SlidersHandler());
        blue.addChangeListener(new SlidersHandler());

        //TODO terminer la textfield
        greeField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
    }

    private class SlidersHandler implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            if(e.getSource() == red)
                redField.setText(String.valueOf(red.getValue()));
            else if (e.getSource() == green)
                greeField.setText(String.valueOf(green.getValue()));
            else
                blueField.setText(String.valueOf(blue.getValue()));

            hexField.setText("#" + Integer.toHexString(red.getValue()) + "" + Integer.toHexString(green.getValue()) + "" + Integer.toHexString(blue.getValue()));

            preview.setBackground(Color.decode(hexField.getText()));
        }
    }


    public static void main(String[] args) {

        ColorChooser ch = new ColorChooser();
    }
}
