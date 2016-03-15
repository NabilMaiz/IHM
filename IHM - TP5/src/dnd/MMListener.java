package dnd;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MMListener implements MouseMotionListener{

    @Override
    public void mouseDragged(MouseEvent e) {
        if(e.getSource() instanceof  JLabel) {
            JLabel toDrag = (JLabel) e.getSource();
            toDrag.getTransferHandler().exportAsDrag(toDrag,e,TransferHandler.COPY);
        }
        else if(e.getSource() instanceof  JFormattedTextField) {
            JFormattedTextField toDrag = (JFormattedTextField) e.getSource();
            toDrag.getTransferHandler().exportAsDrag(toDrag,e,TransferHandler.COPY);
        }


        e.consume();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
