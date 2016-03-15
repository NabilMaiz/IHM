package dnd;


import com.sun.xml.internal.bind.v2.runtime.reflect.opt.OptimizedAccessorFactory;

import javax.swing.*;

public class Frame extends JFrame{

    private JLabel label;
    private JFormattedTextField txt1,txt2;

   public Frame(){
       this.setTitle("Drag Police");
       label = new JLabel("IHM");

       txt1 = new JFormattedTextField("Master 1 Info");
       txt2 = new JFormattedTextField("Université de Lille 1");

       getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
       setLocationRelativeTo(null);
       getContentPane().add(label);
       getContentPane().add(txt1);
       getContentPane().add(txt2);
       txt1.addMouseMotionListener(new MMListener());
       txt2.addMouseMotionListener(new MMListener());

       label.setTransferHandler(new MyTransferHandler());
       label.addMouseMotionListener(new MMListener());

       pack();
       setVisible(true);


   }


    public static void main(String[] args) {
        new Frame();
    }

}



