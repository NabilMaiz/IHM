/**
 * @author <a href="mailto:gery.casiez@lifl.fr">Gery Casiez</a>
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class UndoGUI {
    private DefaultListModel listModel;
    private JTextField text;
    private JList list;

    UndoGUI() {
        // JFrame
        JFrame fen = new JFrame("Undo/Redo");
        fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Liste
        listModel = new DefaultListModel();
        listModel.addElement("Universite Lille 1");
        listModel.addElement("Master informatique");
        listModel.addElement("IHM");
        list = new JList(listModel);
        JScrollPane listScroller = new JScrollPane(list);
        text = new JTextField();
        JButton boutonAjouter = new JButton("Ajouter");

        AbstractAction action = new AjouterAction(this.text, this.listModel);
        text.setAction(action);

        boutonAjouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (text.getText().length() > 0) {
                    listModel.addElement(text.getText());
                    text.setText("");
                }
            }
        });

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Edition");
        menuBar.add(menu);
        JMenuItem menuItem = new JMenuItem("Supprimer");
        menu.add(menuItem);
        menuItem = new JMenuItem("Annuler");
        menu.add(menuItem);
        menuItem = new JMenuItem("Refaire");
        menu.add(menuItem);

        // ToolBar
        JToolBar toolBar = new JToolBar("Barre d'outils");
        JButton boutonSupprimer = new JButton("Supprimer");

        boutonSupprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = list.getSelectedIndex();
                if (index != -1) listModel.remove(index);
            }
        });

        JButton boutonAnnuler = new JButton("Annuler");
        JButton boutonRefaire = new JButton("Refaire");
        toolBar.add(boutonSupprimer);
        toolBar.add(boutonAnnuler);
        toolBar.add(boutonRefaire);

        fen.setJMenuBar(menuBar);
        fen.add(toolBar);
        fen.getContentPane().setLayout(new BoxLayout(fen.getContentPane(),BoxLayout.Y_AXIS));
        fen.getContentPane().add(listScroller);
        fen.getContentPane().add(text);
        fen.getContentPane().add(boutonAjouter);
        fen.pack();
        fen.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UndoGUI();
            }
        });
    }

    static class AjouterAction extends AbstractAction {

        private JTextField text;
        private DefaultListModel listModel;

        public AjouterAction(JTextField text, DefaultListModel listModel) {

            this.text = text;
            this.listModel = listModel;
            putValue(Action.NAME, "Ajouter");
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_A);
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke((char) KeyEvent.VK_ENTER));
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (text.getText().length() > 0) {
                listModel.addElement(text.getText());
                text.setText("");
            }
        }
    }


    static class SuppressionAction extends AbstractAction {

        private JList list;
        private DefaultListModel listModel;

        public SuppressionAction(JList list, DefaultListModel listModel) {

            this.list = list;
            this.listModel = listModel;
            putValue(Action.NAME, "Supprimer");
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_S);
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke((char) KeyEvent.VK_DELETE));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int index = list.getSelectedIndex();
            if (index != -1) listModel.remove(index);
        }
    }


    static class RestaurerAction extends AbstractAction {

        private JTextField text;
        private DefaultListModel listModel;

        public RestaurerAction(JTextField text, DefaultListModel listModel) {

            this.text = text;
            this.listModel = listModel;
            putValue(Action.NAME, "Ajouter");
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_A);
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke((char) KeyEvent.VK_ENTER));
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (text.getText().length() > 0) {
                listModel.addElement(text.getText());
                text.setText("");
            }
        }
    }


}