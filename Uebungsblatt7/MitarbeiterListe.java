import java.util.Arrays;

class MitarbeiterListe {

    private Mitarbeiter[] mitarbeiter;
    private int mitarbeiterAnzahl;
    private int aktuelleMitarbeiterAnzahl;

    public MitarbeiterListe(int mitarbeiterAnzahl) {
        this.mitarbeiterAnzahl = mitarbeiterAnzahl;
        aktuelleMitarbeiterAnzahl = 0;

        mitarbeiter = new Mitarbeiter[mitarbeiterAnzahl];
    }

    int getSize() {
        return aktuelleMitarbeiterAnzahl;
    }

    boolean add(Mitarbeiter m) {
        if(aktuelleMitarbeiterAnzahl == mitarbeiterAnzahl) {
            if(aktuelleMitarbeiterAnzahl == mitarbeiterAnzahl) {
                mitarbeiterAnzahl *= 2;
                mitarbeiter = Arrays.copyOf(mitarbeiter, mitarbeiterAnzahl);
            }
        }

        if(aktuelleMitarbeiterAnzahl < mitarbeiterAnzahl) {
            mitarbeiter[aktuelleMitarbeiterAnzahl] = m;
            aktuelleMitarbeiterAnzahl++;

            return true;
        }

        return false;
    }

    boolean remove(Mitarbeiter m) {
        for(int i = 0; i < mitarbeiterAnzahl-1; i++) {
            if(mitarbeiter[i].equals(m))
            {
                mitarbeiter[i] = null;
                return true;
            }
        }

        return false;
    }

    Mitarbeiter get(int index) {
        if(index < 0 || index > mitarbeiterAnzahl-1)
            return null;

        return mitarbeiter[index];
    }

    Mitarbeiter set(int index, Mitarbeiter m) {
        if(index < 0 || index > mitarbeiterAnzahl-1)
            return null;

        Mitarbeiter tmpMitarbeiter = null;

        if(mitarbeiter[index] != null)
        	tmpMitarbeiter = mitarbeiter[index];

        mitarbeiter[index] = m;

        return tmpMitarbeiter;
    }
}