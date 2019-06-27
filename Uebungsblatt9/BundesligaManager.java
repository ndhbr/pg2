import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;

public class BundesligaManager extends JFrame {

    public BundesligaManager(Tabelle tabelle) {
        setTitle("Bundesligamanager");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        TabelleTableModel tabelleTableModel = new TabelleTableModel(tabelle);

        JTable table = new JTable(tabelleTableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel titlePane = new JPanel();
        titlePane.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createBevelBorder(BevelBorder.RAISED), "Tabelle"
        ));
        titlePane.setLayout(new BorderLayout());
        titlePane.add(scrollPane);

        add(titlePane);
        pack();
        setVisible(true);
    }

    public static void main(String args[]) {
        Tabelle tabelle = new Tabelle();

        tabelle.addEintrag("1. FC Nürnberg", 19);
        tabelle.addEintrag("1. FSV Mainz 05", 43);
        tabelle.addEintrag("Bayer 04 Leverkusen", 58);
        tabelle.addEintrag("Borussia Dortmund", 76);
        tabelle.addEintrag("Borussia M'gladbach", 55);
        tabelle.addEintrag("Eintracht Frankfurt", 54);
        tabelle.addEintrag("FC Augsburg", 32);
        tabelle.addEintrag("FC Bayern München", 78);
        tabelle.addEintrag("FC Schalke 04", 33);
        tabelle.addEintrag("Fortuna 95 Düsseldorf", 44);
        tabelle.addEintrag("Hertha BSC", 43);
        tabelle.addEintrag("Hannover 96", 21);
        tabelle.addEintrag("RasenBallsport Leipzig", 66);
        tabelle.addEintrag("SC Freiburg", 36);
        tabelle.addEintrag("SV Werder Bremen", 53);
        tabelle.addEintrag("TSG 1899 Hoffenheim", 51);
        tabelle.addEintrag("VfB Stuttgart", 28);
        tabelle.addEintrag("VfL Wolfsburg", 55);

        new BundesligaManager(tabelle);
    }
}