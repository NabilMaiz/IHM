package dnd;

import javax.swing.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class MyTransferHandler extends TransferHandler{

    @Override
    public int getSourceActions(JComponent c){
        return COPY_OR_MOVE;
    }

    @Override
    protected Transferable createTransferable(JComponent c){
        if(c instanceof JFormattedTextField)
            return new StringSelection(((JFormattedTextField) c).getText());
        else if (c instanceof JLabel){
            return new StringSelection(((JLabel) c).getText());
        }

        return null;
    }

    @Override
    protected void exportDone(JComponent source, Transferable data, int action){
        if(action == MOVE){
            if(source instanceof JLabel)
                ((JLabel) source).setText("");
            else if(source instanceof  JFormattedTextField)
                ((JFormattedTextField) source).setText("");
        }
    }
}
