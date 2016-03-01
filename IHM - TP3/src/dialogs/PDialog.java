package dialogs;

import javax.swing.*;
import java.awt.*;

public class PDialog extends JDialog {

    public PDialog(JFrame dialog, boolean modal) {
        super(dialog, modal);

        this.setTitle("JDialog");
        this.setSize(new Dimension(160, 120));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
