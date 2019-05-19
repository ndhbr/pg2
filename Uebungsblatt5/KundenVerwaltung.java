import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class KundenVerwaltung extends JFrame {

    private KundeTableModel kundeTableModel;
    private ListSelectionModel kundeSelectionModel;
    private JMenuItem menuItem;

    public class KundenBearbeitenDialog extends JDialog {

        private Kunde kunde;
        private JTextField txtNachname;
        private JTextField txtVorname;

        class MyOkHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nachname = txtNachname.getText();
                String vorname = txtVorname.getText();

                KundenBearbeitenDialog.this.kunde.setNachname(nachname);
                KundenBearbeitenDialog.this.kunde.setVorname(vorname);
                dispose();
        	}
        }

        class MyCancelHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }

        public KundenBearbeitenDialog(JFrame parent, Kunde kunde) {
            super(parent);

            this.kunde = kunde;

            setModal(true);
            setTitle("Kunde bearbeiten");
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLayout(new GridLayout(3, 2));

            add(new JLabel("Nachname"));
            add(this.txtNachname = new JTextField(kunde.getNachname()));
            add(new JLabel("Vorname"));
            add(this.txtVorname = new JTextField(kunde.getVorname()));

            JButton cmdOk = new JButton("Ok");
            add(cmdOk);
            JButton cmdCancel = new JButton("Abbrechen");
            add(cmdCancel);

            cmdOk.addActionListener(new MyOkHandler());
            cmdCancel.addActionListener(new MyCancelHandler());

            pack();
            setVisible(true);
        }
    }

    public KundenVerwaltung(Kunde[] kunden) {
        setTitle("Kundenverwaltung");
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.kundeTableModel = new KundeTableModel(kunden);

        JTable table = new JTable(kundeTableModel);
        kundeSelectionModel = table.getSelectionModel();
        kundeSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        kundeSelectionModel.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent event) {
                if(event.getFirstIndex() > -1)
                    menuItem.setEnabled(true);
                else
                    menuItem.setEnabled(false);
            }
        });

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel titlePane = new JPanel();
        titlePane.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLUE, Color.RED), "Tabellenansicht"
        ));
        titlePane.setLayout(new BorderLayout());
        titlePane.add(scrollPane);

        add(titlePane);

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent event) {
                if(event.getClickCount() == 2) {
                    editKunde();
                }
            }
        });

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu;
        JMenuItem menuItemBeenden = new JMenuItem("Beenden");
        menuItem = new JMenuItem("Kunde bearbeiten");
        menuItem.setEnabled(false);

        menuBar.add(menu = new JMenu("Datei"));

        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                editKunde();
            }
        });

        menu.add(new JSeparator());

        menu.add(menuItemBeenden);
        menuItemBeenden.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void editKunde() {
        int row = kundeSelectionModel.getMinSelectionIndex();
        if(row > -1) {
            new KundenBearbeitenDialog(this, kundeTableModel.getKunde(row));
            kundeTableModel.fireTableRowsUpdated(row, row);
        }
    }

    public static void main(String args[]) {
        Kunde[] kunden = new Kunde[3];
        kunden[0] = new Kunde("Meier", "Josef");
        kunden[1] = new Kunde("Huber", "Franziska");
        kunden[2] = new Kunde("Schmidt", "Helmut");

        KundenVerwaltung kv = new KundenVerwaltung(kunden);
    }
}