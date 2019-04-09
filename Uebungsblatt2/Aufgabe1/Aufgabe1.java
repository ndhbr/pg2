package Uebungsblatt2.Aufgabe1;

public class Aufgabe1 {

    static final int LAENGE = 10;
    static BereichsUmsatz[] umsaetze = new BereichsUmsatz[LAENGE];

    public static void main(String[] args) {

        umsaetze[0] = new BereichsUmsatz("Bremen", 5000.0);
        umsaetze[1] = new BereichsUmsatz("Dresden", 9000.0);
        umsaetze[2] = new BereichsUmsatz("Franfurt", 12000.0);
        umsaetze[3] = new BereichsUmsatz("Hamburg", 1000.0);
        umsaetze[4] = new BereichsUmsatz("Hannover", 8000.0);
        umsaetze[5] = new BereichsUmsatz("Köln", 3000.0);
        umsaetze[6] = new BereichsUmsatz("Leipzig", 3000.0);
        umsaetze[7] = new BereichsUmsatz("München", 4000.0);
        umsaetze[8] = new BereichsUmsatz("Potsdamm", 5000.0);
        umsaetze[9] = new BereichsUmsatz("Stuttgart", 8000.0);

        for(int i = 0; i < LAENGE; i++) {
            System.out.println(umsaetze[i]);
        }

        System.out.println("Durchschnittlicher Umsatz: " + String.valueOf(avgUmsatz(umsaetze)));

        setFlop(umsaetze);
        System.out.println("Letzter: " + umsaetze[LAENGE-1]);

        int changed = set3Tops(umsaetze);
        int count = 1;
        for(int i = 0; i < changed; i++) {
            System.out.println(String.valueOf(count) + ". " + umsaetze[i]);

            if(count < 3)
                count++;
        }
    }

    public static double avgUmsatz(BereichsUmsatz[] umsaetze) {
        double ergebnis = 0.0;

        for(int i = 0; i < LAENGE; i++) {
            ergebnis += umsaetze[i].getUmsatz();
        }

        ergebnis /= LAENGE;

        return ergebnis;
    }

    public static void switchPosition(BereichsUmsatz[] umsaetze, int pos1, int pos2) {
        BereichsUmsatz tmpUmsatz = umsaetze[pos1];
        umsaetze[pos1] = umsaetze[pos2];
        umsaetze[pos2] = tmpUmsatz;
    }

    public static int indexOfMinUmsatz(BereichsUmsatz[] umsaetze) {
        int index = 0;

        for(int i = 0; i < LAENGE; i++) {
            if(umsaetze[i].getUmsatz() < umsaetze[index].getUmsatz())
                index = i;
        }

        return index;
    }

    public static void setFlop(BereichsUmsatz[] umsaetze) {
        int minIndex = indexOfMinUmsatz(umsaetze);
        switchPosition(umsaetze, minIndex, LAENGE-1);
    }

    public static int indexOfMaxUmsatz(BereichsUmsatz[] umsaetze,  int von, int bis) {
        int index = von;

        for(int i = von; i <= bis; i++) {
            if(umsaetze[i].getUmsatz() > umsaetze[index].getUmsatz())
                index = i;
        }

        return index;
    }

    public static int set3Tops(BereichsUmsatz[] umsaetze) {
        int maxIndex = indexOfMaxUmsatz(umsaetze, 0, LAENGE-1);
        switchPosition(umsaetze, maxIndex, 0);

        maxIndex = indexOfMaxUmsatz(umsaetze, 1, LAENGE-1);
        switchPosition(umsaetze, maxIndex, 1);

        maxIndex = indexOfMaxUmsatz(umsaetze, 2, LAENGE-1);
        switchPosition(umsaetze, maxIndex, 2);

        int count = 0;

        for(int i = 3; i < LAENGE; i++) {
            if(umsaetze[i].getUmsatz() == umsaetze[2].getUmsatz()) {
                count++;
                switchPosition(umsaetze, 2+count, i);
            }
        }

        return 3 + count;
    }
}