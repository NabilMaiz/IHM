package questions;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FermetureFenetre extends WindowAdapter {


    public FermetureFenetre() {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Fenetre en cours de fermeture");
        System.exit(0);
    }
}
