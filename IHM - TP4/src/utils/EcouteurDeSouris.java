package utils;

import questions.ArdoiseMagique;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class EcouteurDeSouris implements MouseListener, MouseMotionListener{

    private ArdoiseMagique am;


    public EcouteurDeSouris(ArdoiseMagique am) {
        this.am = am;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        this.am.newCurve();

        if(SwingUtilities.isRightMouseButton(e))
            this.am.clear();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.am.addPoint(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
