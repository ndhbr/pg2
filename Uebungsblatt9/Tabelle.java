import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Tabelle {

    private List<TabellenEintrag> tabellenEintraege;

    public Tabelle() {
        tabellenEintraege = new LinkedList<TabellenEintrag>();
    }

    public void addEintrag(String clubName, int punkte) {
        if(tabellenEintraege.size() > 0) {
            for(TabellenEintrag eintrag : tabellenEintraege) {
                if(eintrag.getPunkte() < punkte) {
                    int index = tabellenEintraege.indexOf(eintrag);
                    TabellenEintrag neuerEintrag = new TabellenEintrag(index+1,
                        clubName, punkte);

                    tabellenEintraege.add(index, neuerEintrag);

                    for(int i = index+1; i < tabellenEintraege.size(); i++) {
                        TabellenEintrag tmp = tabellenEintraege.get(i);
                        tmp.setPlatz(i+1);
                    }

                    break;
                }
            }
        } else {
            tabellenEintraege.add(new TabellenEintrag(1, clubName, punkte));
        }
    }

    public void updatePunkte(int index, int punkte) {
        TabellenEintrag eintrag = getEintrag(index);
        eintrag.setPunkte(punkte);

        for(int i = 0; i < tabellenEintraege.size(); i++) {
            TabellenEintrag a = tabellenEintraege.get(i);

            for(int j = i+1; j < tabellenEintraege.size(); j++) {
                TabellenEintrag b = tabellenEintraege.get(j);

                if(a.getPunkte() < b.getPunkte())
                    Collections.swap(tabellenEintraege, i, j);
            }
        }

        for(int i = 0; i < tabellenEintraege.size(); i++) {
            TabellenEintrag a = tabellenEintraege.get(i);
            a.setPlatz(i+1);
        }
    }

    TabellenEintrag getEintrag(int index) {
        return tabellenEintraege.get(index);
    }

    public int getSize() {
        return tabellenEintraege.size();
    }
}