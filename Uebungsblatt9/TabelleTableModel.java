import javax.swing.table.AbstractTableModel;

public class TabelleTableModel extends AbstractTableModel {

    private Tabelle tabelle;

    public TabelleTableModel() {
        this.tabelle = new Tabelle();
    }

    public TabelleTableModel(Tabelle tabelle) {
        this.tabelle = tabelle;
    }

    @Override
    public String getColumnName(int col) {
        switch(col) {
            case 0: return "Platz";
            case 1: return "Club";
            case 2: return "Punkte";
            default: return null;
        }
    }

    @Override
    public int getRowCount() {
        return this.tabelle.getSize();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TabellenEintrag eintrag = this.tabelle.getEintrag(rowIndex);

        switch(columnIndex) {
            case 0: return eintrag.getPlatz();
            case 1: return eintrag.getClubName();
            case 2: return eintrag.getPunkte();
            default: return "Invalid...";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == 2)
            return true;

        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        TabellenEintrag eintrag = this.tabelle.getEintrag(rowIndex);

        tabelle.updatePunkte(rowIndex,
            Integer.valueOf(String.valueOf(aValue)));
        fireTableDataChanged();
    }

    @Override
    public Class<?> getColumnClass(int column) {
        if (column == 2 || column == 0) {
            return Integer.class;
        }
        return super.getColumnClass(column);
    }
}